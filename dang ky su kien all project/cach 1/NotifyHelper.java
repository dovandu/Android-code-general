package vn.com.famtech.driverorderinmaps.core.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by huan on 6/1/17.
 */

public class NotifyHelper {
    private static NotifyHelper INSTANCE = null;

    private HashMap<String,List<INotifyHelper>> mNotifyStore;

    private NotifyHelper(){
        mNotifyStore = new HashMap<>();
    }

    public static NotifyHelper getInstance(){
        if (INSTANCE == null){
            INSTANCE = new NotifyHelper();
        }
        return INSTANCE;
    }

    public void registerReceiveEvent(String event,INotifyHelper notify){
        List<INotifyHelper> notifyEvent = mNotifyStore.get(event);
        if (notifyEvent == null){
            notifyEvent = new ArrayList<>();
        }
        if (!notifyEvent.contains(notify)){
            notifyEvent.add(notify);
        }
        mNotifyStore.put(event,notifyEvent);
    }

    public void unRegisterReceiveEvent(String event,INotifyHelper notify){
        List<INotifyHelper> notifyEvent = mNotifyStore.get(event);
        if (notifyEvent == null){
            notifyEvent = new ArrayList<>();
        }
        if (notifyEvent.contains(notify)){
            notifyEvent.remove(notify);
        }
        mNotifyStore.put(event,notifyEvent);
    }

    public void notifyDataChanged(String event,Object data){
        List<INotifyHelper> notifyEvent = mNotifyStore.get(event);
        if (notifyEvent != null){
            for (INotifyHelper notify : notifyEvent){
                if (notify != null){
                    notify.onReceiveEvent(data);
                }
            }
        }
    }

    public void unRegisterAll(){
        mNotifyStore = new HashMap<>();
    }

    public interface INotifyHelper{
        void onReceiveEvent(Object data);
    }
}
