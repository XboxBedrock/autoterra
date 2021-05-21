package asia.buildtheearth.xboxbedrock.autoterra;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

@Mod(modid = AutoTerra.MODID, name = AutoTerra.NAME, version = AutoTerra.VERSION)
public class AutoTerra
{
    public static final String MODID = "autoterra";
    public static final String NAME = "Auto Terra";
    public static final String VERSION = "1.0";
    //InputStream in =
    //BufferedReader reader = new BufferedReader(new InputStreamReader(in));

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("AutoTerra Started");
        MinecraftForge.EVENT_BUS.register(AutoTerra.class);

        logger.warn("11111111111111111111111111111111111111111111111111111111");
    }
    @SubscribeEvent
    public static void clientChatEvent(ClientChatEvent event) throws IOException, InterruptedException {
        logger.warn("eeeeeeeeeeeeeeeeeeeeeeee");
        if (event.getOriginalMessage().contains("autoterra start")) {
            logger.warn("222222222222222222222222222222222222222222222");

            BufferedReader br = new BufferedReader(new InputStreamReader(AutoTerra.class.getResourceAsStream("/tpllcoords.txt")));
                try {
                    String line;

                    while ((line = br.readLine()) != null) {
                        logger.warn(line);
                        TimeUnit.MILLISECONDS.sleep(500);
                        Minecraft.getMinecraft().player.sendChatMessage(line.replaceAll("\\r\\n|\\r|\\n", ""));
                    }
                } finally {
                    br.close();
                }

        }
    }
}


