package com.springbootprojectdress.Basics.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFeedback {

    private String feedback;

    private Users users;
}
