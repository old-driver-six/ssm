package com.bj186.oas.service.system;

import com.bj186.oas.pojo.Staff;

public interface UserService {
    Staff select(String name, Integer staffID, String depName, Integer position, Integer pageNumber, Integer pageSize);
}
