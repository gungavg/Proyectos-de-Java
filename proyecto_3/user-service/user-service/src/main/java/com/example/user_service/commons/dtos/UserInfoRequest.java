package com.example.user_service.commons.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoRequest {
    private Long userId;
}
