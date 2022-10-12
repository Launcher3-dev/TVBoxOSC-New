package com.github.tvbox.osc.player.controller;

import android.util.Log;

import org.cybergarage.upnp.Action;
import org.cybergarage.upnp.Device;
import org.cybergarage.upnp.Service;

public class DeviceController {

    public static String AV_TRANSPORT = "urn:schemas-upnp-org:service:AVTransport:1";
    public static String RENDERING_CONTROL = "urn:schemas-upnp-org:service:RenderingControl:1";

    public static String SET_URL = "SetAVTransportURI";
    public static String CURRENT_URL = "CurrentURI";

    public static String PLAY = "Play";
    public static String PAUSE = "Pause";

    public static String GET_POSITION_INFO = "GetPositionInfo";
    public static String TRACK_DURATION = "TrackDuration";
    public static String ABS_TIME = "AbsTime";

    private static DeviceController sController;
    public Device device;
    public String url;

    public static DeviceController get() {
        if (sController == null) {
            sController = new DeviceController();
        }
        return sController;
    }


    private DeviceController() {
    }

    public void init(Device device, String url) {
        this.device = device;
        this.url = url;
    }

    public boolean setUrl() {
        if (url == null) {
            Log.e("zx", "PostControl:set url failed, url == null");
            return false;
        }
        Service service = device.getService(AV_TRANSPORT);
        if (service == null) return false;
        Log.d("zx", "setUrl:" + service.getServiceNode().toString());
        Action setUrl = service.getAction(SET_URL);
        if (setUrl == null) return false;
        setUrl.setArgumentValue("InstanceID", 0);
        setUrl.setArgumentValue(CURRENT_URL, url);
        setUrl.setArgumentValue("CurrentURIMetaData", "");
        if (!setUrl.postControlAction()) {
            Log.e("zx", "PostControl:set url failed");
            return false;
        }
        return true;
    }

    public boolean pause() {
        Service service = device.getService(AV_TRANSPORT);
        if (service == null) return false;
        Log.d("zx", "pause:" + service.getServiceNode().toString());
        Action pause = service.getAction(PAUSE);
        if (pause == null) return false;
        pause.setArgumentValue("InstanceID", 0);
        if (!pause.postControlAction()) {
            Log.e("zx", "Control:pause failed");
            return false;
        }
        return true;
    }

    public boolean play() {
        Service service = device.getService(AV_TRANSPORT);
        if (service == null) return false;
        Log.d("zx", "play:" + service.getServiceNode().toString());
        Action play = service.getAction(PLAY);
        if (play == null) return false;
        play.setArgumentValue("InstanceID", 0);
        if (!play.postControlAction()) {
            Log.e("zx", "Control:play failed");
            return false;
        }
        return true;
    }

    public MediaPositionInfo getPositionInfo() {
        Service service = device.getService(AV_TRANSPORT);
        if (service == null) return null;
        Log.d("zx", "getPositionInfo:" + service.getServiceNode().toString());
        Action info = service.getAction(GET_POSITION_INFO);
        if (info == null) return null;
        info.setArgumentValue("InstanceID", 0);
        if (!info.postControlAction()) {
            Log.e("zx", "Control:getPositionInfo failed");
            return null;
        } else {
            String trackDuration = info.getArgumentValue(TRACK_DURATION);
            String absTime = info.getArgumentValue(ABS_TIME);
            return new MediaPositionInfo(trackDuration, absTime);
        }
    }

}