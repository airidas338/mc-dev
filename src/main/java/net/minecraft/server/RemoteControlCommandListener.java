package net.minecraft.server;


public class RemoteControlCommandListener implements ICommandListener {

   private static final RemoteControlCommandListener a = new RemoteControlCommandListener();
   private StringBuffer b = new StringBuffer();


   public static RemoteControlCommandListener h() {
      return a;
   }

   public void i() {
      this.b.setLength(0);
   }

   public String j() {
      return this.b.toString();
   }

   public String getName() {
      return "Rcon";
   }

   public IChatBaseComponent getScoreboardDisplayName() {
      return new ChatComponentText(this.getName());
   }

   public void sendMessage(IChatBaseComponent var1) {
      this.b.append(var1.c());
   }

   public boolean a(int var1, String var2) {
      return true;
   }

   public Location getLocation() {
      return new Location(0, 0, 0);
   }

   public Vec3D d() {
      return new Vec3D(0.0D, 0.0D, 0.0D);
   }

   public World getWorld() {
      return MinecraftServer.M().getWorld();
   }

   public Entity f() {
      return null;
   }

   public boolean t_() {
      return true;
   }

   public void a(ag var1, int var2) {}

}
