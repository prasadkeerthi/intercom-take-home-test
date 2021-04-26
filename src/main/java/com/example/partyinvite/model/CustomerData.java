package com.example.partyinvite.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Customer data.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerData {
    public int user_id;

    public String name;

    public double latitude;

    public double longitude;

}
