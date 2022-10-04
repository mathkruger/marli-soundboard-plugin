package com.mathkruger.marlisoundboard.utilities;

import com.eu.habbo.Emulator;
import com.mathkruger.marlisoundboard.models.MarliSong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckDatabase {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckDatabase.class);

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

            reloadPermissions = registerPermission("cmd_marli", reloadPermissions);
            reloadPermissions = registerPermission("cmd_louvarMarli", reloadPermissions);

            if (reloadPermissions)
                Emulator.getGameEnvironment().getPermissionsManager().reload();
        } catch (Exception e) {
            LOGGER.error(" [Marli Soundboard] Failed to check database for permissions", e);
        }
    }

    public static List<MarliSong> IGetMarliSongsList() throws Exception {
        List<MarliSong> songs = new ArrayList<>();

        try (Connection connection = Emulator.getDatabase().getDataSource().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "SELECT `song_id`, `song_name` FROM `marli_songs`"
            )) {
                if (statement.execute()) {
                    ResultSet resultSet = statement.getResultSet();

                    while (resultSet.next()) {
                        MarliSong song = new MarliSong();
                        song.setSongId(resultSet.getString("song_id"));
                        song.setSongName(resultSet.getString("song_name"));
                    }
                }
                else {
                    LOGGER.error("[Marli Soundboard] No songs found, did you run the sql script??");
                }
            }
        } catch (SQLException sql) {
            LOGGER.error(" [Marli Soundboard] Failed to load Marli Songs", sql);
        }

        return songs;
    }


}
