package api.Pojo.Put.updateUserInPetstore;

import api.Pojo.Post.createUserInPetstore.Creation;

public class Update extends Creation {

    public Update(Integer id, String username, String firstName,
                  String lastName, String email, String password,
                  String phone, Integer userStatus) {
        super(id, username, firstName, lastName, email, password, phone, userStatus);
    }
}
