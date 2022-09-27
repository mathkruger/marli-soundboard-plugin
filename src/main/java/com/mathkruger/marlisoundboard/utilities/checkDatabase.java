package com.mathkruger.marlisoundboard.utilities;

import com.eu.habbo.Emulator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class checkDatabase {
    private static final Logger LOGGER = LoggerFactory.getLogger(checkDatabase.class);

    private static boolean registerPermission(String name, boolean defaultReturn) {
        try (Connection connection = Emulator.getDatabase().getDataSource().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "SELECT `column_name` FROM INFORMATION_SCHEMA.COLUMNS WHERE `table_name` = 'permissions' AND `column_name` = '"
                            + name + "'")) {
                while (!statement.executeQuery().next())
                    try (PreparedStatement statement_ = connection.prepareStatement(
                            "ALTER TABLE `permissions` ADD `" + name + "` ENUM('0', '1', '2') NOT NULL DEFAULT '1'")) {
                        statement_.execute();
                        return true;
                    }
                return true;
            }
        } catch (SQLException sql) {
            LOGGER.error(" [Marli Soundboard] Failed to check database for permission: " + name, sql);
        }

        return defaultReturn;
    }

    public static void ICheckDatabase() throws Exception {
        try {
            boolean reloadPermissions = false;

            reloadPermissions = registerPermission("cmd_playMarli", reloadPermissions);
            reloadPermissions = registerPermission("cmd_controlMarli", reloadPermissions);

            if (reloadPermissions)
                Emulator.getGameEnvironment().getPermissionsManager().reload();
        } catch (Exception e) {
            LOGGER.error(" [Marli Soundboard] Failed to check database for permissions", e);
        }
    }

}
