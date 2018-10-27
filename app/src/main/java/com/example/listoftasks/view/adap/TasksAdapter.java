package com.example.listoftasks.view.adap;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.listoftasks.R;
import com.example.listoftasks.model.BeanTask;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.ViewHolder> {

    private List<BeanTask> beanTasks;

    public TasksAdapter(List<BeanTask> beanTasks) {
        this.beanTasks = beanTasks;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_tasks_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BeanTask beanTask = beanTasks.get(position);
        Context context = holder.itemView.getContext();

        holder.txttTaskId.setText(beanTask.getId());
        holder.txtDescTask.setText(Html.fromHtml(String.format(context.getString(R.string.text_description),
                beanTask.getTask())));
    }

    public List<BeanTask> getBeanTasks() {
        return beanTasks;
    }

    public void setBeanTasks(List<BeanTask> beanTasks) {
        this.beanTasks = beanTasks;
    }

    @Override
    public int getItemCount() {
        return beanTasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.task_id)
        TextView txttTaskId;
        @BindView(R.id.desc_task)
        TextView txtDescTask;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
