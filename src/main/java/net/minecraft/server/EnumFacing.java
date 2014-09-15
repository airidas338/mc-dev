package net.minecraft.server;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Random;

public enum EnumFacing implements IName {

   DOWN("DOWN", 0, 0, 1, -1, "down", em.b, el.b, new fd(0, -1, 0)),
   UP("UP", 1, 1, 0, -1, "up", em.a, el.b, new fd(0, 1, 0)),
   NORTH("NORTH", 2, 2, 3, 2, "north", em.b, el.c, new fd(0, 0, -1)),
   SOUTH("SOUTH", 3, 3, 2, 0, "south", em.a, el.c, new fd(0, 0, 1)),
   WEST("WEST", 4, 4, 5, 1, "west", em.b, el.a, new fd(-1, 0, 0)),
   EAST("EAST", 5, 5, 4, 3, "east", em.a, el.a, new fd(1, 0, 0));
   private final int g;
   private final int h;
   private final int i;
   private final String j;
   private final el k;
   private final em l;
   private final fd m;
   private static final EnumFacing[] n = new EnumFacing[6];
   private static final EnumFacing[] o = new EnumFacing[4];
   private static final Map p = Maps.newHashMap();
   // $FF: synthetic field
   private static final EnumFacing[] q = new EnumFacing[]{DOWN, UP, NORTH, SOUTH, WEST, EAST};


   private EnumFacing(String var1, int var2, int var3, int var4, int var5, String var6, em var7, el var8, fd var9) {
      this.g = var3;
      this.i = var5;
      this.h = var4;
      this.j = var6;
      this.k = var8;
      this.l = var7;
      this.m = var9;
   }

   public int a() {
      return this.g;
   }

   public int b() {
      return this.i;
   }

   public em c() {
      return this.l;
   }

   public EnumFacing d() {
      return a(this.h);
   }

   public EnumFacing e() {
      switch(ek.b[this.ordinal()]) {
      case 1:
         return EAST;
      case 2:
         return SOUTH;
      case 3:
         return WEST;
      case 4:
         return NORTH;
      default:
         throw new IllegalStateException("Unable to get Y-rotated facing of " + this);
      }
   }

   public EnumFacing f() {
      switch(ek.b[this.ordinal()]) {
      case 1:
         return WEST;
      case 2:
         return NORTH;
      case 3:
         return EAST;
      case 4:
         return SOUTH;
      default:
         throw new IllegalStateException("Unable to get CCW facing of " + this);
      }
   }

   public int g() {
      return this.k == el.a?this.l.a():0;
   }

   public int h() {
      return this.k == el.b?this.l.a():0;
   }

   public int i() {
      return this.k == el.c?this.l.a():0;
   }

   public String j() {
      return this.j;
   }

   public el k() {
      return this.k;
   }

   public static EnumFacing a(int var0) {
      return n[MathHelper.a(var0 % n.length)];
   }

   public static EnumFacing b(int var0) {
      return o[MathHelper.a(var0 % o.length)];
   }

   public static EnumFacing a(double var0) {
      return b(MathHelper.floor(var0 / 90.0D + 0.5D) & 3);
   }

   public static EnumFacing a(Random var0) {
      return values()[var0.nextInt(values().length)];
   }

   public String toString() {
      return this.j;
   }

   public String getName() {
      return this.j;
   }

   static {
      EnumFacing[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         EnumFacing var3 = var0[var2];
         n[var3.g] = var3;
         if(var3.k().c()) {
            o[var3.i] = var3;
         }

         p.put(var3.j().toLowerCase(), var3);
      }

   }
}
