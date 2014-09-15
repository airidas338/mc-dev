package net.minecraft.server;
import com.google.common.collect.Sets;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class qy {

   private static final Logger p = LogManager.getLogger();
   public Entity a;
   public int b;
   public int c;
   public int d;
   public int e;
   public int f;
   public int g;
   public int h;
   public int i;
   public double j;
   public double k;
   public double l;
   public int m;
   private double q;
   private double r;
   private double s;
   private boolean t;
   private boolean u;
   private int v;
   private Entity w;
   private boolean x;
   private boolean y;
   public boolean n;
   public Set o = Sets.newHashSet();


   public qy(Entity var1, int var2, int var3, boolean var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.u = var4;
      this.d = MathHelper.floor(var1.s * 32.0D);
      this.e = MathHelper.floor(var1.t * 32.0D);
      this.f = MathHelper.floor(var1.u * 32.0D);
      this.g = MathHelper.d(var1.y * 256.0F / 360.0F);
      this.h = MathHelper.d(var1.z * 256.0F / 360.0F);
      this.i = MathHelper.d(var1.aD() * 256.0F / 360.0F);
      this.y = var1.C;
   }

   public boolean equals(Object var1) {
      return var1 instanceof qy?((qy)var1).a.F() == this.a.F():false;
   }

   public int hashCode() {
      return this.a.F();
   }

   public void a(List var1) {
      this.n = false;
      if(!this.t || this.a.e(this.q, this.r, this.s) > 16.0D) {
         this.q = this.a.s;
         this.r = this.a.t;
         this.s = this.a.u;
         this.t = true;
         this.n = true;
         this.b(var1);
      }

      if(this.w != this.a.m || this.a.m != null && this.m % 60 == 0) {
         this.w = this.a.m;
         this.a((Packet)(new PacketPlayOutAttachEntity(0, this.a, this.a.m)));
      }

      if(this.a instanceof EntityItemFrame && this.m % 10 == 0) {
         EntityItemFrame var2 = (EntityItemFrame)this.a;
         ItemStack var3 = var2.o();
         if(var3 != null && var3.b() instanceof ItemWorldMap) {
            WorldMap var4 = Items.bd.a(var3, this.a.o);
            Iterator var5 = var1.iterator();

            while(var5.hasNext()) {
               EntityHuman var6 = (EntityHuman)var5.next();
               EntityPlayer var7 = (EntityPlayer)var6;
               var4.a(var7, var3);
               Packet var8 = Items.bd.c(var3, this.a.o, var7);
               if(var8 != null) {
                  var7.a.sendPacket(var8);
               }
            }
         }

         this.b();
      }

      if(this.m % this.c == 0 || this.a.ai || this.a.H().a()) {
         int var23;
         int var24;
         if(this.a.m == null) {
            ++this.v;
            var23 = MathHelper.floor(this.a.s * 32.0D);
            var24 = MathHelper.floor(this.a.t * 32.0D);
            int var25 = MathHelper.floor(this.a.u * 32.0D);
            int var27 = MathHelper.d(this.a.y * 256.0F / 360.0F);
            int var28 = MathHelper.d(this.a.z * 256.0F / 360.0F);
            int var29 = var23 - this.d;
            int var30 = var24 - this.e;
            int var9 = var25 - this.f;
            Object var10 = null;
            boolean var11 = Math.abs(var29) >= 4 || Math.abs(var30) >= 4 || Math.abs(var9) >= 4 || this.m % 60 == 0;
            boolean var12 = Math.abs(var27 - this.g) >= 4 || Math.abs(var28 - this.h) >= 4;
            if(this.m > 0 || this.a instanceof EntityArrow) {
               if(var29 >= -128 && var29 < 128 && var30 >= -128 && var30 < 128 && var9 >= -128 && var9 < 128 && this.v <= 400 && !this.x && this.y == this.a.C) {
                  if(var11 && var12) {
                     var10 = new ka(this.a.F(), (byte)var29, (byte)var30, (byte)var9, (byte)var27, (byte)var28, this.a.C);
                  } else if(var11) {
                     var10 = new jz(this.a.F(), (byte)var29, (byte)var30, (byte)var9, this.a.C);
                  } else if(var12) {
                     var10 = new kb(this.a.F(), (byte)var27, (byte)var28, this.a.C);
                  }
               } else {
                  this.y = this.a.C;
                  this.v = 0;
                  var10 = new PacketPlayOutEntityTeleport(this.a.F(), var23, var24, var25, (byte)var27, (byte)var28, this.a.C);
               }
            }

            if(this.u) {
               double var13 = this.a.v - this.j;
               double var15 = this.a.w - this.k;
               double var17 = this.a.x - this.l;
               double var19 = 0.02D;
               double var21 = var13 * var13 + var15 * var15 + var17 * var17;
               if(var21 > var19 * var19 || var21 > 0.0D && this.a.v == 0.0D && this.a.w == 0.0D && this.a.x == 0.0D) {
                  this.j = this.a.v;
                  this.k = this.a.w;
                  this.l = this.a.x;
                  this.a((Packet)(new PacketPlayOutEntityVelocity(this.a.F(), this.j, this.k, this.l)));
               }
            }

            if(var10 != null) {
               this.a((Packet)var10);
            }

            this.b();
            if(var11) {
               this.d = var23;
               this.e = var24;
               this.f = var25;
            }

            if(var12) {
               this.g = var27;
               this.h = var28;
            }

            this.x = false;
         } else {
            var23 = MathHelper.d(this.a.y * 256.0F / 360.0F);
            var24 = MathHelper.d(this.a.z * 256.0F / 360.0F);
            boolean var26 = Math.abs(var23 - this.g) >= 4 || Math.abs(var24 - this.h) >= 4;
            if(var26) {
               this.a((Packet)(new kb(this.a.F(), (byte)var23, (byte)var24, this.a.C)));
               this.g = var23;
               this.h = var24;
            }

            this.d = MathHelper.floor(this.a.s * 32.0D);
            this.e = MathHelper.floor(this.a.t * 32.0D);
            this.f = MathHelper.floor(this.a.u * 32.0D);
            this.b();
            this.x = true;
         }

         var23 = MathHelper.d(this.a.aD() * 256.0F / 360.0F);
         if(Math.abs(var23 - this.i) >= 4) {
            this.a((Packet)(new PacketPlayOutEntityHeadRotation(this.a, (byte)var23)));
            this.i = var23;
         }

         this.a.ai = false;
      }

      ++this.m;
      if(this.a.G) {
         this.b((Packet)(new PacketPlayOutEntityVelocity(this.a)));
         this.a.G = false;
      }

   }

   private void b() {
      DataWatcher var1 = this.a.H();
      if(var1.a()) {
         this.b((Packet)(new PacketPlayOutEntityMetadata(this.a.F(), var1, false)));
      }

      if(this.a instanceof EntityLiving) {
         yf var2 = (yf)((EntityLiving)this.a).getAttributeMap();
         Set var3 = var2.b();
         if(!var3.isEmpty()) {
            this.b((Packet)(new PacketPlayOutUpdateAttributes(this.a.F(), var3)));
         }

         var3.clear();
      }

   }

   public void a(Packet var1) {
      Iterator var2 = this.o.iterator();

      while(var2.hasNext()) {
         EntityPlayer var3 = (EntityPlayer)var2.next();
         var3.a.sendPacket(var1);
      }

   }

   public void b(Packet var1) {
      this.a(var1);
      if(this.a instanceof EntityPlayer) {
         ((EntityPlayer)this.a).a.sendPacket(var1);
      }

   }

   public void a() {
      Iterator var1 = this.o.iterator();

      while(var1.hasNext()) {
         EntityPlayer var2 = (EntityPlayer)var1.next();
         var2.d(this.a);
      }

   }

   public void a(EntityPlayer var1) {
      if(this.o.contains(var1)) {
         var1.d(this.a);
         this.o.remove(var1);
      }

   }

   public void b(EntityPlayer var1) {
      if(var1 != this.a) {
         if(this.c(var1)) {
            if(!this.o.contains(var1) && (this.e(var1) || this.a.n)) {
               this.o.add(var1);
               Packet var2 = this.c();
               var1.a.sendPacket(var2);
               if(!this.a.H().d()) {
                  var1.a.sendPacket((Packet)(new PacketPlayOutEntityMetadata(this.a.F(), this.a.H(), true)));
               }

               NBTTagCompound var3 = this.a.aU();
               if(var3 != null) {
                  var1.a.sendPacket((Packet)(new jl(this.a.F(), var3)));
               }

               if(this.a instanceof EntityLiving) {
                  yf var4 = (yf)((EntityLiving)this.a).getAttributeMap();
                  Collection var5 = var4.c();
                  if(!var5.isEmpty()) {
                     var1.a.sendPacket((Packet)(new PacketPlayOutUpdateAttributes(this.a.F(), var5)));
                  }
               }

               this.j = this.a.v;
               this.k = this.a.w;
               this.l = this.a.x;
               if(this.u && !(var2 instanceof PacketPlayOutSpawnEntityLiving)) {
                  var1.a.sendPacket((Packet)(new PacketPlayOutEntityVelocity(this.a.F(), this.a.v, this.a.w, this.a.x)));
               }

               if(this.a.m != null) {
                  var1.a.sendPacket((Packet)(new PacketPlayOutAttachEntity(0, this.a, this.a.m)));
               }

               if(this.a instanceof EntityInsentient && ((EntityInsentient)this.a).cc() != null) {
                  var1.a.sendPacket((Packet)(new PacketPlayOutAttachEntity(1, this.a, ((EntityInsentient)this.a).cc())));
               }

               if(this.a instanceof EntityLiving) {
                  for(int var7 = 0; var7 < 5; ++var7) {
                     ItemStack var8 = ((EntityLiving)this.a).p(var7);
                     if(var8 != null) {
                        var1.a.sendPacket((Packet)(new PacketPlayOutEntityEquipment(this.a.F(), var7, var8)));
                     }
                  }
               }

               if(this.a instanceof EntityHuman) {
                  EntityHuman var10 = (EntityHuman)this.a;
                  if(var10.bI()) {
                     var1.a.sendPacket((Packet)(new PacketPlayOutBed(var10, new Location(this.a))));
                  }
               }

               if(this.a instanceof EntityLiving) {
                  EntityLiving var9 = (EntityLiving)this.a;
                  Iterator var11 = var9.bk().iterator();

                  while(var11.hasNext()) {
                     MobEffect var6 = (MobEffect)var11.next();
                     var1.a.sendPacket((Packet)(new PacketPlayOutEntityEffect(this.a.F(), var6)));
                  }
               }
            }
         } else if(this.o.contains(var1)) {
            this.o.remove(var1);
            var1.d(this.a);
         }

      }
   }

   public boolean c(EntityPlayer var1) {
      double var2 = var1.s - (double)(this.d / 32);
      double var4 = var1.u - (double)(this.f / 32);
      return var2 >= (double)(-this.b) && var2 <= (double)this.b && var4 >= (double)(-this.b) && var4 <= (double)this.b && this.a.a(var1);
   }

   private boolean e(EntityPlayer var1) {
      return var1.u().t().a(var1, this.a.ae, this.a.ag);
   }

   public void b(List var1) {
      for(int var2 = 0; var2 < var1.size(); ++var2) {
         this.b((EntityPlayer)var1.get(var2));
      }

   }

   private Packet c() {
      if(this.a.I) {
         p.warn("Fetching addPacket for removed entity");
      }

      if(this.a instanceof EntityItem) {
         return new PacketPlayOutSpawnEntity(this.a, 2, 1);
      } else if(this.a instanceof EntityPlayer) {
         return new PacketPlayOutNamedEntitySpawn((EntityHuman)this.a);
      } else if(this.a instanceof EntityMinecartAbstract) {
         EntityMinecartAbstract var9 = (EntityMinecartAbstract)this.a;
         return new PacketPlayOutSpawnEntity(this.a, 10, var9.s().a());
      } else if(this.a instanceof EntityBoat) {
         return new PacketPlayOutSpawnEntity(this.a, 1);
      } else if(this.a instanceof wt) {
         this.i = MathHelper.d(this.a.aD() * 256.0F / 360.0F);
         return new PacketPlayOutSpawnEntityLiving((EntityLiving)this.a);
      } else if(this.a instanceof EntityFishingHook) {
         EntityHuman var8 = ((EntityFishingHook)this.a).b;
         return new PacketPlayOutSpawnEntity(this.a, 90, var8 != null?var8.F():this.a.F());
      } else if(this.a instanceof EntityArrow) {
         Entity var7 = ((EntityArrow)this.a).c;
         return new PacketPlayOutSpawnEntity(this.a, 60, var7 != null?var7.F():this.a.F());
      } else if(this.a instanceof EntitySnowball) {
         return new PacketPlayOutSpawnEntity(this.a, 61);
      } else if(this.a instanceof EntityPotion) {
         return new PacketPlayOutSpawnEntity(this.a, 73, ((EntityPotion)this.a).o());
      } else if(this.a instanceof EntityThrownExpBottle) {
         return new PacketPlayOutSpawnEntity(this.a, 75);
      } else if(this.a instanceof EntityEnderPearl) {
         return new PacketPlayOutSpawnEntity(this.a, 65);
      } else if(this.a instanceof EntityEnderSignal) {
         return new PacketPlayOutSpawnEntity(this.a, 72);
      } else if(this.a instanceof EntityFireworks) {
         return new PacketPlayOutSpawnEntity(this.a, 76);
      } else {
         PacketPlayOutSpawnEntity var2;
         if(this.a instanceof EntityFireball) {
            EntityFireball var6 = (EntityFireball)this.a;
            var2 = null;
            byte var10 = 63;
            if(this.a instanceof EntitySmallFireball) {
               var10 = 64;
            } else if(this.a instanceof EntityWitherSkull) {
               var10 = 66;
            }

            if(var6.a != null) {
               var2 = new PacketPlayOutSpawnEntity(this.a, var10, ((EntityFireball)this.a).a.F());
            } else {
               var2 = new PacketPlayOutSpawnEntity(this.a, var10, 0);
            }

            var2.d((int)(var6.b * 8000.0D));
            var2.e((int)(var6.c * 8000.0D));
            var2.f((int)(var6.d * 8000.0D));
            return var2;
         } else if(this.a instanceof EntityEgg) {
            return new PacketPlayOutSpawnEntity(this.a, 62);
         } else if(this.a instanceof EntityTNTPrimed) {
            return new PacketPlayOutSpawnEntity(this.a, 50);
         } else if(this.a instanceof EntityEnderCrystal) {
            return new PacketPlayOutSpawnEntity(this.a, 51);
         } else if(this.a instanceof EntityFallingBlock) {
            EntityFallingBlock var5 = (EntityFallingBlock)this.a;
            return new PacketPlayOutSpawnEntity(this.a, 70, Block.f(var5.l()));
         } else if(this.a instanceof EntityArmorStand) {
            return new PacketPlayOutSpawnEntity(this.a, 78);
         } else if(this.a instanceof EntityPainting) {
            return new PacketPlayOutSpawnEntityPainting((EntityPainting)this.a);
         } else {
            Location var3;
            if(this.a instanceof EntityItemFrame) {
               EntityItemFrame var4 = (EntityItemFrame)this.a;
               var2 = new PacketPlayOutSpawnEntity(this.a, 71, var4.b.b());
               var3 = var4.n();
               var2.a(MathHelper.d((float)(var3.n() * 32)));
               var2.b(MathHelper.d((float)(var3.o() * 32)));
               var2.c(MathHelper.d((float)(var3.p() * 32)));
               return var2;
            } else if(this.a instanceof EntityLeash) {
               EntityLeash var1 = (EntityLeash)this.a;
               var2 = new PacketPlayOutSpawnEntity(this.a, 77);
               var3 = var1.n();
               var2.a(MathHelper.d((float)(var3.n() * 32)));
               var2.b(MathHelper.d((float)(var3.o() * 32)));
               var2.c(MathHelper.d((float)(var3.p() * 32)));
               return var2;
            } else if(this.a instanceof EntityExperienceOrb) {
               return new PacketPlayOutSpawnEntityExperienceOrb((EntityExperienceOrb)this.a);
            } else {
               throw new IllegalArgumentException("Don\'t know how to add " + this.a.getClass() + "!");
            }
         }
      }
   }

   public void d(EntityPlayer var1) {
      if(this.o.contains(var1)) {
         this.o.remove(var1);
         var1.d(this.a);
      }

   }

}
