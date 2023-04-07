package Controllers;

import Entities.UserEntity;
import Services.AdminUserDashBoardService;

public class AdminUserDashBoardController {
    public static void updateUserData(UserEntity user) {
        AdminUserDashBoardService.updateUserData(user);
    }
}
