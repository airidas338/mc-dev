package net.minecraft.server;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class qn {

   private static final Logger a = LogManager.getLogger();
   private final qt b;
   private Set c = Sets.newHashSet();
   private um d = new um();
   private int e;


   public qn(qt var1) {
      this.b = var1;
      this.e = var1.r().an().d();
   }

   public void a(wv var1) {
      if(var1 instanceof qw) {
         this.a(var1, 512, 2);
         qw var2 = (qw)var1;
         Iterator var3 = this.c.iterator();

         while(var3.hasNext()) {
            qy var4 = (qy)var3.next();
            if(var4.a != var2) {
               var4.b(var2);
            }
         }
      } else if(var1 instanceof ado) {
         this.a(var1, 64, 5, true);
      } else if(var1 instanceof ahj) {
         this.a(var1, 64, 20, false);
      } else if(var1 instanceof ahp) {
         this.a(var1, 64, 10, false);
      } else if(var1 instanceof ahl) {
         this.a(var1, 64, 10, false);
      } else if(var1 instanceof ahq) {
         this.a(var1, 64, 10, true);
      } else if(var1 instanceof aht) {
         this.a(var1, 64, 10, true);
      } else if(var1 instanceof ahk) {
         this.a(var1, 64, 4, true);
      } else if(var1 instanceof ahs) {
         this.a(var1, 64, 10, true);
      } else if(var1 instanceof ahv) {
         this.a(var1, 64, 10, true);
      } else if(var1 instanceof ahu) {
         this.a(var1, 64, 10, true);
      } else if(var1 instanceof ahm) {
         this.a(var1, 64, 10, true);
      } else if(var1 instanceof adw) {
         this.a(var1, 64, 20, true);
      } else if(var1 instanceof adx) {
         this.a(var1, 80, 3, true);
      } else if(var1 instanceof adu) {
         this.a(var1, 80, 3, true);
      } else if(var1 instanceof aco) {
         this.a(var1, 64, 3, true);
      } else if(var1 instanceof adf) {
         this.a(var1, 80, 3, false);
      } else if(var1 instanceof abo) {
         this.a(var1, 80, 3, false);
      } else if(var1 instanceof adb) {
         this.a(var1, 160, 3, true);
      } else if(var1 instanceof wt) {
         this.a(var1, 80, 3, true);
      } else if(var1 instanceof aek) {
         this.a(var1, 160, 10, true);
      } else if(var1 instanceof adv) {
         this.a(var1, 160, 20, true);
      } else if(var1 instanceof adj) {
         this.a(var1, 160, Integer.MAX_VALUE, false);
      } else if(var1 instanceof adi) {
         this.a(var1, 160, 3, true);
      } else if(var1 instanceof xk) {
         this.a(var1, 160, 20, true);
      } else if(var1 instanceof ada) {
         this.a(var1, 256, Integer.MAX_VALUE, false);
      }

   }

   public void a(wv var1, int var2, int var3) {
      this.a(var1, var2, var3, false);
   }

   public void a(wv var1, int var2, int var3, boolean var4) {
      if(var2 > this.e) {
         var2 = this.e;
      }

      try {
         if(this.d.b(var1.F())) {
            throw new IllegalStateException("Entity is already tracked!");
         }

         qy var5 = new qy(var1, var2, var3, var4);
         this.c.add(var5);
         this.d.a(var1.F(), var5);
         var5.b(this.b.j);
      } catch (Throwable var11) {
         bRenamed var6 = b.a(var11, "Adding entity to track");
         j var7 = var6.a("Entity To Track");
         var7.a("Tracking range", (Object)(var2 + " blocks"));
         var7.a("Update interval", (Callable)(new qo(this, var3)));
         var1.a(var7);
         j var8 = var6.a("Entity That Is Already Tracked");
         ((qy)this.d.a(var1.F())).a.a(var8);

         try {
            throw new u(var6);
         } catch (u var10) {
            a.error("\"Silently\" catching entity tracking error.", var10);
         }
      }

   }

   public void b(wv var1) {
      if(var1 instanceof qw) {
         qw var2 = (qw)var1;
         Iterator var3 = this.c.iterator();

         while(var3.hasNext()) {
            qy var4 = (qy)var3.next();
            var4.a(var2);
         }
      }

      qy var5 = (qy)this.d.d(var1.F());
      if(var5 != null) {
         this.c.remove(var5);
         var5.a();
      }

   }

   public void a() {
      ArrayList var1 = Lists.newArrayList();
      Iterator var2 = this.c.iterator();

      while(var2.hasNext()) {
         qy var3 = (qy)var2.next();
         var3.a(this.b.j);
         if(var3.n && var3.a instanceof qw) {
            var1.add((qw)var3.a);
         }
      }

      for(int var6 = 0; var6 < var1.size(); ++var6) {
         qw var7 = (qw)var1.get(var6);
         Iterator var4 = this.c.iterator();

         while(var4.hasNext()) {
            qy var5 = (qy)var4.next();
            if(var5.a != var7) {
               var5.b(var7);
            }
         }
      }

   }

   public void a(qw var1) {
      Iterator var2 = this.c.iterator();

      while(var2.hasNext()) {
         qy var3 = (qy)var2.next();
         if(var3.a == var1) {
            var3.b(this.b.j);
         } else {
            var3.b(var1);
         }
      }

   }

   public void a(wv var1, id var2) {
      qy var3 = (qy)this.d.a(var1.F());
      if(var3 != null) {
         var3.a(var2);
      }

   }

   public void b(wv var1, id var2) {
      qy var3 = (qy)this.d.a(var1.F());
      if(var3 != null) {
         var3.b(var2);
      }

   }

   public void b(qw var1) {
      Iterator var2 = this.c.iterator();

      while(var2.hasNext()) {
         qy var3 = (qy)var2.next();
         var3.d(var1);
      }

   }

   public void a(qw var1, bfh var2) {
      Iterator var3 = this.c.iterator();

      while(var3.hasNext()) {
         qy var4 = (qy)var3.next();
         if(var4.a != var1 && var4.a.ae == var2.a && var4.a.ag == var2.b) {
            var4.b(var1);
         }
      }

   }

}
