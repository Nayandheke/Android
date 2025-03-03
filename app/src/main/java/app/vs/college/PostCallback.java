package app.vs.college;

import java.util.List;

public interface PostCallback {
    void onSuccess(List<Posts> postsList);
    void onFailure(String error);
}
