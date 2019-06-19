package com.bj186.oas.service.system;

import com.bj186.oas.pojo.Staff;

import java.util.List;

public interface UserService {
   Staff select(String name, Integer staffID, String depName, Integer position, Integer pageNumber, Integer pageSize);
}
