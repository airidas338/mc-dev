package net.minecraft.server;



public class MonsterEggInfo {

   public final int a;
   public final int b;
   public final int c;
   public final Statistic d;
   public final Statistic e;


   public MonsterEggInfo(int var1, int var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = StatisticList.a(this);
      this.e = StatisticList.b(this);
   }
}
