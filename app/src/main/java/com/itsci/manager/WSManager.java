package com.itsci.manager;

import android.content.Context;
import android.util.Log;

import com.itsci.it411_asynctask.R;
import com.itsci.model.EventModel;
import com.itsci.model.LoginModel;
import com.itsci.model.MemberModel;
import com.itsci.model.TimeModel;
import com.itsci.model.UserModel;
import com.itsci.task.WSTask;

import java.util.ArrayList;

public class WSManager {
    private static WSManager wsManager;
    private Context context;

    public interface WSManagerListener {
        void onComplete(Object response);

        void onError(String err);
    }

    public WSManager(Context context) {
        this.context = context;
    }

    public static WSManager getWsManager(Context context) {
        if (wsManager == null)
            wsManager = new WSManager(context);
        return wsManager;
    }

    public void doRegister(Object object, final WSManagerListener listener){
        if (!(object instanceof MemberModel)) {
            return;
        }
        MemberModel memberModel = (MemberModel) object;
        memberModel.toJSONString();

        WSTask task = new WSTask(this.context, new WSTask.WSTaskListener() {
            @Override
            public void onComplete(String response) {
                MemberModel memberModel = new MemberModel(response);
                listener.onComplete(memberModel);
            }

            @Override
            public void onError(String err) {
                listener.onError(err);
            }
        });

        Log.d("data" , memberModel.toJSONString());
        task.execute(context.getString(R.string.register_url),memberModel.toJSONString());
    }

    public void doLogin(Object object, final WSManagerListener listener) {
        if (!(object instanceof MemberModel)) {
            return;
        }
        MemberModel memberModel = (MemberModel) object;
        memberModel.toJSONString();
        WSTask task = new WSTask(this.context,new WSTask.WSTaskListener() {
            @Override
            public void onComplete(String response) {
                listener.onComplete(response);
            }

            @Override
            public void onError(String err) {
                listener.onError(err);
            }
        });

        task.execute(context.getString(R.string.login_url), memberModel.toJSONString());
    }
    public void doLogins(Object object, final WSManagerListener listener) {
        if (!(object instanceof LoginModel)) {
            return;
        }
        LoginModel loginModel = (LoginModel) object;
        loginModel.toJSONString();
        WSTask task = new WSTask(this.context,new WSTask.WSTaskListener() {
            @Override
            public void onComplete(String response) {
                listener.onComplete(response);
            }

            @Override
            public void onError(String err) {
                listener.onError(err);
            }
        });

        task.execute(context.getString(R.string.login_url), loginModel.toJSONString());
    }

    public void doEditProfile(Object object, final WSManagerListener listener) {
        if (!(object instanceof MemberModel)) {
            return;
        }
        MemberModel memberModel = (MemberModel) object;
        memberModel.toJSONString();
        WSTask task = new WSTask(this.context,new WSTask.WSTaskListener() {
            @Override
            public void onComplete(String response) {
                MemberModel userModel = new MemberModel(response);
                listener.onComplete(userModel);
            }

            @Override
            public void onError(String err) {
                listener.onError(err);
            }
        });

        Log.d("data ", memberModel.toJSONString());
        task.execute(context.getString(R.string.edit_profile_url), memberModel.toJSONString());
    }
    public void doDeleteUser(Object object, final WSManagerListener listener) {
        if (!(object instanceof UserModel)) {
            return;
        }
        UserModel userModel = (UserModel) object;
        userModel.toJSONString();
        WSTask task = new WSTask(this.context,new WSTask.WSTaskListener() {
            @Override
            public void onComplete(String response) {
                UserModel userModel = new UserModel(response);
                listener.onComplete(userModel);
            }

            @Override
            public void onError(String err) {
                listener.onError(err);
            }
        });

        Log.d("data ", userModel.toJSONString());
        task.execute(context.getString(R.string.delete_user_url), userModel.toJSONString());
    }

    public void getMember(Object object, final WSManagerListener listener) {
        if (!(object instanceof MemberModel)) {
            return;
        }
        MemberModel memberModel = (MemberModel) object;
        memberModel.toJSONString();
        WSTask task = new WSTask(this.context,new WSTask.WSTaskListener() {
            @Override
            public void onComplete(String response) {
                listener.onComplete(response);
            }

            @Override
            public void onError(String err) {
                listener.onError(err);
            }
        });

        task.execute(context.getString(R.string.get_profile_url), memberModel.toJSONString());
    }

    public void getLogin(Object object, final WSManagerListener listener){
        if (!(object instanceof MemberModel)) {
            return;
        }
        MemberModel memberModel = (MemberModel) object;
        memberModel.toJSONString();
        WSTask task = new WSTask(this.context, new WSTask.WSTaskListener() {
            @Override
            public void onComplete(String response) {
                listener.onComplete(response);
            }

            @Override
            public void onError(String err) {
                listener.onError(err);
            }
        });

        task.execute(context.getString(R.string.get_login_url), memberModel.toJSONString());
    }


    public void getListEvent(Object object, final WSManagerListener listener){
        if (!(object instanceof EventModel)) {
            return;
        }
        EventModel eventModel = (EventModel) object;
        eventModel.toJSONString();
        WSTask task = new WSTask(this.context, new WSTask.WSTaskListener() {
            @Override
            public void onComplete(String response) {
                listener.onComplete(response);
            }

            @Override
            public void onError(String err) {
                listener.onError(err);
            }
        });

        task.execute(context.getString(R.string.get_event_url), eventModel.toJSONString());
    }

    public void getEvent(Object object, final WSManagerListener listener){
        if (!(object instanceof EventModel)) {
            return;
        }
        EventModel eventModel = (EventModel) object;
        eventModel.toJSONString();
        WSTask task = new WSTask(this.context, new WSTask.WSTaskListener() {
            @Override
            public void onComplete(String response) {
                listener.onComplete(response);
            }

            @Override
            public void onError(String err) {
                listener.onError(err);
            }
        });

        task.execute(context.getString(R.string.get_eventtt_url), eventModel.toJSONString());
    }

    public void getTime(Object object, final WSManagerListener listener){
        if (!(object instanceof TimeModel)) {
            return;
        }
        TimeModel timeModel = (TimeModel) object;
        timeModel.toJSONString();
        WSTask task = new WSTask(this.context, new WSTask.WSTaskListener() {
            @Override
            public void onComplete(String response) {
                listener.onComplete(response);
            }

            @Override
            public void onError(String err) {
                listener.onError(err);
            }
        });

        task.execute(context.getString(R.string.get_time_url), timeModel.toJSONString());
    }
}
