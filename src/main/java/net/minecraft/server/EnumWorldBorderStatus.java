package net.minecraft.server;

public enum EnumWorldBorderStatus {

   GROWING("GROWING", 0, 4259712),
   SHRINKING("SHRINKING", 1, 16724016),
   STATIONARY("STATIONARY", 2, 2138367);
   private final int d;
   // $FF: synthetic field
   private static final EnumWorldBorderStatus[] e = new EnumWorldBorderStatus[]{GROWING, SHRINKING, STATIONARY};


   private EnumWorldBorderStatus(String var1, int var2, int var3) {
      this.d = var3;
   }

}
