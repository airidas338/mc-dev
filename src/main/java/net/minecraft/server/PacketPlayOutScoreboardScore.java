package net.minecraft.server;

public class PacketPlayOutScoreboardScore implements Packet {

   private String a = "";
   private String b = "";
   private int c;
   private EnumScoreAction d;


   public PacketPlayOutScoreboardScore() {}

   public PacketPlayOutScoreboardScore(ScoreboardScore var1) {
      this.a = var1.getPlayerName();
      this.b = var1.getObjective().getName();
      this.c = var1.getScore();
      this.d = EnumScoreAction.CHANGE;
   }

   public PacketPlayOutScoreboardScore(String var1) {
      this.a = var1;
      this.b = "";
      this.c = 0;
      this.d = EnumScoreAction.REMOVE;
   }

   public PacketPlayOutScoreboardScore(String var1, ScoreboardObjective var2) {
      this.a = var1;
      this.b = var2.getName();
      this.c = 0;
      this.d = EnumScoreAction.REMOVE;
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.c(40);
      this.d = (EnumScoreAction)var1.a(EnumScoreAction.class);
      this.b = var1.c(16);
      if(this.d != EnumScoreAction.REMOVE) {
         this.c = var1.e();
      }

   }

   public void b(PacketDataSerializer var1) {
      var1.a(this.a);
      var1.a((Enum)this.d);
      var1.a(this.b);
      if(this.d != EnumScoreAction.REMOVE) {
         var1.b(this.c);
      }

   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
