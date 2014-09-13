package net.minecraft.server;

public enum avh implements IName {

   a("LEFT", 0),
   b("RIGHT", 1);
   // $FF: synthetic field
   private static final avh[] c = new avh[]{a, b};


   private avh(String var1, int var2) {}

   public String toString() {
      return this.getName();
   }

   public String getName() {
      return this == a?"left":"right";
   }

}
