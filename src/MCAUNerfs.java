import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MCAUNerfs extends Plugin {

	static final Logger log = Logger.getLogger("Minecraft");
    static String LOG_PREFIX = "[MCAUNerfs] : ";
	static Server server = etc.getServer();
    
	private ArrayList<PluginRegisteredListener> listeners = new ArrayList<PluginRegisteredListener>();
	
    public void enable() {
		log.info(LOG_PREFIX+"Mod Enabled.");
    }

    public void disable() {
		PluginLoader loader = etc.getLoader();
		for (PluginRegisteredListener rl : listeners)
			loader.removeListener(rl);
		listeners.clear();
        
        log.info(LOG_PREFIX+"Mod Disabled");
    }
    
    public void initialize() {
    	Listener l = new Listener();

        listeners.add(etc.getLoader().addListener(PluginLoader.Hook.EXPLODE, l, this, PluginListener.Priority.LOW));
        listeners.add(etc.getLoader().addListener(PluginLoader.Hook.IGNITE, l, this, PluginListener.Priority.LOW));
        listeners.add(etc.getLoader().addListener(PluginLoader.Hook.BURN, l, this, PluginListener.Priority.LOW));
    }
    
    private class Listener extends PluginListener {
    	public boolean onExplode(Block block) {
    		return true;
    	}
    	
    	public boolean onBurn(Block block) {
    		return true;
    	}
    	
    	public boolean onIgnite(Block block, Player player) {
    		return true;	
    	}
    }
}
