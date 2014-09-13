package net.minecraft.server;

public enum avg implements IName {

   a("UPPER", 0),
   b("LOWER", 1);
   // $FF: synthetic field
   private static final avg[] c = new avg[]{a, b};


   private avg(String var1, int var2) {}

   public String toString() {
      return this.getName();
   }

   public String getName() {
      return this == a?"upper":"lower";
   }

}
