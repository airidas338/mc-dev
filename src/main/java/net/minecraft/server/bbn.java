package net.minecraft.server;

// $FF: synthetic class
class bbn {

   // $FF: synthetic field
   static final int[] a = new int[EnumFacing.values().length];


   static {
      try {
         a[EnumFacing.EAST.ordinal()] = 1;
      } catch (NoSuchFieldError var6) {
         ;
      }

      try {
         a[EnumFacing.WEST.ordinal()] = 2;
      } catch (NoSuchFieldError var5) {
         ;
      }

      try {
         a[EnumFacing.SOUTH.ordinal()] = 3;
      } catch (NoSuchFieldError var4) {
         ;
      }

      try {
         a[EnumFacing.NORTH.ordinal()] = 4;
      } catch (NoSuchFieldError var3) {
         ;
      }

      try {
         a[EnumFacing.DOWN.ordinal()] = 5;
      } catch (NoSuchFieldError var2) {
         ;
      }

      try {
         a[EnumFacing.UP.ordinal()] = 6;
      } catch (NoSuchFieldError var1) {
         ;
      }

   }
}
