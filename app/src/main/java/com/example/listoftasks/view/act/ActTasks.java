package com.example.listoftasks.view.act;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.listoftasks.AppDemo;
import com.example.listoftasks.R;
import com.example.listoftasks.di.comp.DaggerCompConActivity;
import com.example.listoftasks.di.mod.ModActivity;
import com.example.listoftasks.model.BeanTask;
import com.example.listoftasks.pre.PreActComputers;
import com.example.listoftasks.view.ViewActTasks;
import com.example.listoftasks.view.adap.TasksAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class ActTasks extends ActBase implements ViewActTasks, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recyclerTasks)
    RecyclerView ioRecyclerTasks;
    @BindView(R.id.lnEmpty)
    LinearLayout lnEmpty;
    @BindView(R.id.srlTasks)
    SwipeRefreshLayout srlTasks;

    private TasksAdapter tasksAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<BeanTask> iaBeanTask = new ArrayList<>();
    private Context context;

    @Inject
    PreActComputers ioPreActComputers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerCompConActivity.builder().compApplication(((AppDemo) getApplication()).component())
                .modActivity(new ModActivity(this, this)).build().inject(this);

        initializeToolbar();
        initializeAdapter();
        getTasks();
    }

    private void initializeAdapter() {
        srlTasks.setColorSchemeColors(ContextCompat.getColor(this, android.R.color.holo_blue_light)
                , ContextCompat.getColor(this, android.R.color.holo_green_light)
                , ContextCompat.getColor(this, android.R.color.holo_red_light)
                , ContextCompat.getColor(this, android.R.color.holo_orange_light));
        srlTasks.setOnRefreshListener(this);

        layoutManager = new LinearLayoutManager(this);
        tasksAdapter = new TasksAdapter(iaBeanTask);
        ioRecyclerTasks.setAdapter(tasksAdapter);
        ioRecyclerTasks.setLayoutManager(layoutManager);
        ioRecyclerTasks.setItemAnimator(new DefaultItemAnimator());
    }

    private void initializeToolbar() {
        getSupportActionBar().setTitle(getString(R.string.text_title_computers));
    }

    @OnClick(R.id.fab)
    void onClickFab(){
        showDialog();
    }

    private void showDialog(){
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.dialog_custom, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        alertDialogBuilder.setView(promptsView);

        final EditText userInput = (EditText) promptsView
                .findViewById(R.id.input_task);

        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("AGREGAR",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                int lastId = iaBeanTask.size() + 1;
                                BeanTask loBeanTask = new BeanTask();
                                loBeanTask.setTask(userInput.getText().toString())
                                .setId(String.valueOf(lastId));

                                iaBeanTask.add(loBeanTask);
                                tasksAdapter.notifyDataSetChanged();
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }

    private void getTasks() {
        ioPreActComputers.getTasks();
    }

    @Override
    public void setContext() {
        context = ActTasks.this;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_tasks;
    }

    @Override
    public void onSuccess(String message, List<BeanTask> paBeanTask) {

        srlTasks.setRefreshing(false);

        if (paBeanTask != null && paBeanTask.size() > 0) {
            iaBeanTask = paBeanTask;
            lnEmpty.setVisibility(View.GONE);
            ioRecyclerTasks.setVisibility(View.VISIBLE);
            tasksAdapter.setBeanTasks(iaBeanTask);
            tasksAdapter.notifyDataSetChanged();
        } else {
            iaBeanTask = new ArrayList<>();
            tasksAdapter.setBeanTasks(iaBeanTask);
            tasksAdapter.notifyDataSetChanged();
            lnEmpty.setVisibility(View.VISIBLE);
            ioRecyclerTasks.setVisibility(View.GONE);
        }
    }

    @Override
    public void onLoading(String poMessage) {
        Toast.makeText(this, poMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String poMessage) {
        srlTasks.setRefreshing(false);
        Toast.makeText(this, poMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public void onRefresh() {
        srlTasks.setRefreshing(true);
        getTasks();
    }
}
