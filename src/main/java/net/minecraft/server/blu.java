package net.minecraft.server;

// $FF: synthetic class
class blu {

   // $FF: synthetic field
   static final int[] a;
   // $FF: synthetic field
   static final int[] b = new int[EnumFacing.values().length];


   static {
      try {
         b[EnumFacing.NORTH.ordinal()] = 1;
      } catch (NoSuchFieldError var8) {
         ;
      }

      try {
         b[EnumFacing.SOUTH.ordinal()] = 2;
      } catch (NoSuchFieldError var7) {
         ;
      }

      try {
         b[EnumFacing.WEST.ordinal()] = 3;
      } catch (NoSuchFieldError var6) {
         ;
      }

      try {
         b[EnumFacing.EAST.ordinal()] = 4;
      } catch (NoSuchFieldError var5) {
         ;
      }

      a = new int[bml.values().length];

      try {
         a[bml.a.ordinal()] = 1;
      } catch (NoSuchFieldError var4) {
         ;
      }

      try {
         a[bml.b.ordinal()] = 2;
      } catch (NoSuchFieldError var3) {
         ;
      }

      try {
         a[bml.c.ordinal()] = 3;
      } catch (NoSuchFieldError var2) {
         ;
      }

      try {
         a[bml.d.ordinal()] = 4;
      } catch (NoSuchFieldError var1) {
         ;
      }

   }
}
