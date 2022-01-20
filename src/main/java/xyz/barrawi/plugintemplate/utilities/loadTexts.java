package xyz.barrawi.plugintemplate.utilities;

import com.eu.habbo.Emulator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class loadTexts {
    private static final Logger LOGGER = LoggerFactory.getLogger(loadTexts.class);

    public static void loadTexts() throws Exception {
        try {
            Emulator.getTexts().register("commands.description.cmd_kisses", ":kisses <user>");
            Emulator.getTexts().register("cmd_kisses.keys", "kisses");
            Emulator.getTexts().register("cmd_kisses.error.no_user", "You need to specify a user.");
            Emulator.getTexts().register("cmd_kisses.error.self", "You can't kiss yourself.");
            Emulator.getTexts().register("cmd_kisses.error.too_far", "You are too far away to kiss that user.");
            Emulator.getTexts().register("cmd_kisses.error.not_found", "Could not find user %user%.");
            Emulator.getTexts().register("cmd_kisses.kisser", "You kissed %user%.");
            Emulator.getTexts().register("cmd_kisses.kissed", "%user% kissed you.");

            Emulator.getTexts().register("commands.description.cmd_boom", ":boom <user>");
            Emulator.getTexts().register("cmd_boom.keys", "boom");
            Emulator.getTexts().register("cmd_boom.error.no_user", "You need to specify a user.");
            Emulator.getTexts().register("cmd_boom.error.self", "You can't boom yourself.");
            Emulator.getTexts().register("cmd_boom.error.too_far", "You are too far away to boom that user.");
            Emulator.getTexts().register("cmd_boom.error.not_found", "Could not find user %user%.");
            Emulator.getTexts().register("cmd_boom.boomer", "You boomed %user%.");
            Emulator.getTexts().register("cmd_boom.boomed", "%user% boomed you.");
            Emulator.getTexts().register("cmd_boom.error.not_allowed_room", "You can't boom in this room.");

            Emulator.getTexts().register("commands.description.cmd_pet", ":pet <user>");
            Emulator.getTexts().register("cmd_pet.keys", "pet");
            Emulator.getTexts().register("cmd_pet.error.no_user", "You need to specify a user.");
            Emulator.getTexts().register("cmd_pet.error.self", "You can't pet yourself.");
            Emulator.getTexts().register("cmd_pet.error.too_far", "You are too far away to pet that user.");
            Emulator.getTexts().register("cmd_pet.error.not_found", "Could not find user %user%.");
            Emulator.getTexts().register("cmd_pet.petter", "You petted %user%.");
            Emulator.getTexts().register("cmd_pet.petted", "%user% petted you.");

            Emulator.getTexts().register("commands.description.cmd_highfive", ":highfive <user>");
            Emulator.getTexts().register("cmd_highfive.keys", "highfive;hf");
            Emulator.getTexts().register("cmd_highfive.error.no_user", "You need to specify a user.");
            Emulator.getTexts().register("cmd_highfive.error.self", "You can't highfive yourself.");
            Emulator.getTexts().register("cmd_highfive.error.too_far", "You are too far away to highfive that user.");
            Emulator.getTexts().register("cmd_highfive.error.not_found", "Could not find user %user%.");
            Emulator.getTexts().register("cmd_highfive.highfiver", "You highfived %user%.");
            Emulator.getTexts().register("cmd_highfive.highfived", "%user% highfived you.");

        } catch (Exception e) {
            LOGGER.error(" [Plugin Template] Error while loading texts", e);
        }
    }

}
