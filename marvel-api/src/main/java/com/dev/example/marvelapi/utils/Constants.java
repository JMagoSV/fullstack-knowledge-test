/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.example.marvelapi.utils;

/**
 *
 * @author Mauricio González
 */
public interface Constants {
    String SUCCESS = "success";
    enum ASSIGNMENT_TYPE {
        USER {
            @Override
            public String toString() {
                return "USER";
            }
        },
        GROUP {
            @Override
            public String toString() {
                return "GROUP";
            }
        },
        ZONE {
            @Override
            public String toString() {
                return "ZONE";
            }
        }
    }
}
