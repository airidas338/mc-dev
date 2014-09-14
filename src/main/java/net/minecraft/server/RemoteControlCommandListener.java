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

   public String d_() {
      return "Rcon";
   }

   public IChatBaseComponent e_() {
      return new ChatComponentText(this.d_());
   }

   public void a(IChatBaseComponent var1) {
      this.b.append(var1.c());
   }

   public boolean a(int var1, String var2) {
      return true;
   }

   public Location c() {
      return new Location(0, 0, 0);
   }

   public Vec3D d() {
      return new Vec3D(0.0D, 0.0D, 0.0D);
   }

   public World e() {
      return MinecraftServer.M().e();
   }

   public Entity f() {
      return null;
   }

   public boolean t_() {
      return true;
   }

   public void a(ag var1, int var2) {}

}
