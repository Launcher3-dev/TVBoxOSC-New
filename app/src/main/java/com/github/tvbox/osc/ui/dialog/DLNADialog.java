package com.github.tvbox.osc.ui.dialog;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.github.tvbox.osc.R;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import org.cybergarage.upnp.Device;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DLNADialog extends BaseDialog {

    private List<Device> mDevices = new ArrayList<>();
    private TextView mSearchingTv;
    private ProgressBar mProgressBar;
    private Adapter mAdapter;

    public interface DLNADialogInterface {
        void click(Device value, int pos);
    }

    public DLNADialog(@NonNull Context context, DLNADialogInterface dialogInterface) {
        super(context);
        View decorView = ((Activity) context).getWindow().getDecorView();
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.width = (int) (decorView.getWidth() * 0.65);
        lp.height = (int) (decorView.getHeight() * 0.75);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_dlna, null);
        setContentView(view, lp);
        mProgressBar = view.findViewById(R.id.dlna_progress);
        mSearchingTv = view.findViewById(R.id.searching);
        mAdapter = new Adapter(stringDiff, dialogInterface);
        TvRecyclerView tvRecyclerView = ((TvRecyclerView) findViewById(R.id.list));
        tvRecyclerView.setAdapter(mAdapter);
    }

    public void addDevices(List<Device> devices) {
        if (!devices.isEmpty()) {
            if (mProgressBar.getVisibility() != View.GONE) {
                mProgressBar.setVisibility(View.GONE);
                mSearchingTv.setVisibility(View.GONE);
            }
            mDevices.addAll(devices);
            mAdapter.setData(mDevices);
        }
    }

    public void addDevice(Device device) {
        if (mProgressBar.getVisibility() != View.GONE) {
            mProgressBar.setVisibility(View.GONE);
            mSearchingTv.setVisibility(View.GONE);
        }
        mDevices.add(device);
        mAdapter.setData(mDevices);
    }

    public void removeDevice(Device device) {
        mDevices.remove(device);
        mAdapter.setData(mDevices);
    }

    public static DiffUtil.ItemCallback<Device> stringDiff = new DiffUtil.ItemCallback<Device>() {

        @Override
        public boolean areItemsTheSame(@NonNull @NotNull Device oldItem, @NonNull @NotNull Device newItem) {
            return oldItem.getFriendlyName().equals(newItem.getFriendlyName());
        }

        @Override
        public boolean areContentsTheSame(@NonNull @NotNull Device oldItem, @NonNull @NotNull Device newItem) {
            return oldItem.getFriendlyName().equals(newItem.getFriendlyName());
        }
    };

    public static class Adapter<T> extends ListAdapter<T, ViewHolder> {
        private final List<Device> data = new ArrayList<>();
        private DLNADialogInterface dialogInterface;

        protected Adapter(@NonNull DiffUtil.ItemCallback<T> diffCallback, DLNADialogInterface dialogInterface) {
            super(diffCallback);
            this.dialogInterface = dialogInterface;
        }

        public void setData(List<Device> newData) {
            data.clear();
            data.addAll(newData);
            notifyDataSetChanged();
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dialog_device, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Device device = data.get(position);
            ((TextView) holder.itemView.findViewById(R.id.deviceName)).setText(device.getFriendlyName() + "");
            ((TextView) holder.itemView.findViewById(R.id.deviceName)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogInterface.click(device, position);
                }
            });
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }
}
