package net.minecraft.server;

public class ko implements Packet {

   private String a;
   private String b;


   public ko() {}

   public ko(String var1, String var2) {
      this.a = var1;
      this.b = var2;
      if(var2.length() > 40) {
         throw new IllegalArgumentException("Hash is too long (max 40, was " + var2.length() + ")");
      }
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.c(32767);
      this.b = var1.c(40);
   }

   public void b(PacketDataSerializer var1) {
      var1.a(this.a);
      var1.a(this.b);
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
