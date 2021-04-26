package com.example.partyinvite.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Invitee data.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InviteeData {

    public int user_id;

    public String name;

    public double distance;
}
