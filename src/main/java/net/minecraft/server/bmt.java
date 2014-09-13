package net.minecraft.server;

// $FF: synthetic class
class bmt {

   // $FF: synthetic field
   static final int[] a = new int[EnumFacing.values().length];


   static {
      try {
         a[EnumFacing.NORTH.ordinal()] = 1;
      } catch (NoSuchFieldError var4) {
         ;
      }

      try {
         a[EnumFacing.SOUTH.ordinal()] = 2;
      } catch (NoSuchFieldError var3) {
         ;
      }

      try {
         a[EnumFacing.WEST.ordinal()] = 3;
      } catch (NoSuchFieldError var2) {
         ;
      }

      try {
         a[EnumFacing.EAST.ordinal()] = 4;
      } catch (NoSuchFieldError var1) {
         ;
      }

   }
}
