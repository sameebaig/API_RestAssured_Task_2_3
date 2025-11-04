
package api.endpoints;

public class Routes {
    public static String base_url = "https://reqres.in/api";

    public static String get_users = base_url + "/users?page=2";
    public static String create_user = base_url + "/users";
    public static String update_user = base_url + "/users/{id}";
    public static String patch_user  = base_url + "/users/{id}";
    public static String delete_user = base_url + "/users/{id}";
}
