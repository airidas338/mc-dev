package net.minecraft.server;


public interface ICommandListener {

   String getName();

   IChatBaseComponent getScoreboardDisplayName();

   void sendMessage(IChatBaseComponent var1);

   boolean a(int var1, String var2);

   Location getLocation();

   Vec3D d();

   World getWorld();

   Entity f();

   boolean t_();

   void a(ag var1, int var2);
}
