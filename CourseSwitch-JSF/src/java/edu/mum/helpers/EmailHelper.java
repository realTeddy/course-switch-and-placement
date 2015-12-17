/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.helpers;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EmailHelper {
    
    public static void sendRejectionEmail() {
        Logger.getLogger(EmailHelper.class.getName()).log(Level.INFO, null, "Email Sent");
    }
    
    public static void sendApprovalEmail() {
        Logger.getLogger(EmailHelper.class.getName()).log(Level.INFO, null, "Email Sent");
    }
}
