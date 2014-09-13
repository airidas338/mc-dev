package net.minecraft.server;

enum avj implements IName {

   a("UPPER", 0),
   b("LOWER", 1);
   // $FF: synthetic field
   private static final avj[] c = new avj[]{a, b};


   private avj(String var1, int var2) {}

   public String toString() {
      return this.getName();
   }

   public String getName() {
      return this == a?"upper":"lower";
   }

}
