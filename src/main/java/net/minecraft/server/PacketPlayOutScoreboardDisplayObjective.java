package net.minecraft.server;

public class PacketPlayOutScoreboardDisplayObjective implements Packet {

   private int a;
   private String b;


   public PacketPlayOutScoreboardDisplayObjective() {}

   public PacketPlayOutScoreboardDisplayObjective(int var1, ScoreboardObjective var2) {
      this.a = var1;
      if(var2 == null) {
         this.b = "";
      } else {
         this.b = var2.getName();
      }

   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.readByte();
      this.b = var1.c(16);
   }

   public void b(PacketDataSerializer var1) {
      var1.writeByte(this.a);
      var1.a(this.b);
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
