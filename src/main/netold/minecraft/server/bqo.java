package net.minecraft.server;
import java.util.concurrent.Callable;

public class bqo {

   public static final vt a = vt.c;
   private long b;
   private are c;
   private String d;
   private int e;
   private int f;
   private int g;
   private long h;
   private long i;
   private long j;
   private long k;
   private fn l;
   private int m;
   private String n;
   private int o;
   private int p;
   private boolean q;
   private int r;
   private boolean s;
   private int t;
   private arc u;
   private boolean v;
   private boolean w;
   private boolean x;
   private boolean y;
   private vt z;
   private boolean A;
   private double B;
   private double C;
   private double D;
   private long E;
   private double F;
   private double G;
   private double H;
   private int I;
   private int J;
   private aqq K;


   protected bqo() {
      this.c = are.b;
      this.d = "";
      this.B = 0.0D;
      this.C = 0.0D;
      this.D = 6.0E7D;
      this.E = 0L;
      this.F = 0.0D;
      this.G = 5.0D;
      this.H = 0.2D;
      this.I = 5;
      this.J = 15;
      this.K = new aqq();
   }

   public bqo(fn var1) {
      this.c = are.b;
      this.d = "";
      this.B = 0.0D;
      this.C = 0.0D;
      this.D = 6.0E7D;
      this.E = 0L;
      this.F = 0.0D;
      this.G = 5.0D;
      this.H = 0.2D;
      this.I = 5;
      this.J = 15;
      this.K = new aqq();
      this.b = var1.g("RandomSeed");
      if(var1.b("generatorName", 8)) {
         String var2 = var1.j("generatorName");
         this.c = are.a(var2);
         if(this.c == null) {
            this.c = are.b;
         } else if(this.c.f()) {
            int var3 = 0;
            if(var1.b("generatorVersion", 99)) {
               var3 = var1.f("generatorVersion");
            }

            this.c = this.c.a(var3);
         }

         if(var1.b("generatorOptions", 8)) {
            this.d = var1.j("generatorOptions");
         }
      }

      this.u = arc.a(var1.f("GameType"));
      if(var1.b("MapFeatures", 99)) {
         this.v = var1.n("MapFeatures");
      } else {
         this.v = true;
      }

      this.e = var1.f("SpawnX");
      this.f = var1.f("SpawnY");
      this.g = var1.f("SpawnZ");
      this.h = var1.g("Time");
      if(var1.b("DayTime", 99)) {
         this.i = var1.g("DayTime");
      } else {
         this.i = this.h;
      }

      this.j = var1.g("LastPlayed");
      this.k = var1.g("SizeOnDisk");
      this.n = var1.j("LevelName");
      this.o = var1.f("version");
      this.p = var1.f("clearWeatherTime");
      this.r = var1.f("rainTime");
      this.q = var1.n("raining");
      this.t = var1.f("thunderTime");
      this.s = var1.n("thundering");
      this.w = var1.n("hardcore");
      if(var1.b("initialized", 99)) {
         this.y = var1.n("initialized");
      } else {
         this.y = true;
      }

      if(var1.b("allowCommands", 99)) {
         this.x = var1.n("allowCommands");
      } else {
         this.x = this.u == arc.c;
      }

      if(var1.b("Player", 10)) {
         this.l = var1.m("Player");
         this.m = this.l.f("Dimension");
      }

      if(var1.b("GameRules", 10)) {
         this.K.a(var1.m("GameRules"));
      }

      if(var1.b("Difficulty", 99)) {
         this.z = vt.a(var1.d("Difficulty"));
      }

      if(var1.b("DifficultyLocked", 1)) {
         this.A = var1.n("DifficultyLocked");
      }

      if(var1.b("BorderCenterX", 99)) {
         this.B = var1.i("BorderCenterX");
      }

      if(var1.b("BorderCenterZ", 99)) {
         this.C = var1.i("BorderCenterZ");
      }

      if(var1.b("BorderSize", 99)) {
         this.D = var1.i("BorderSize");
      }

      if(var1.b("BorderSizeLerpTime", 99)) {
         this.E = var1.g("BorderSizeLerpTime");
      }

      if(var1.b("BorderSizeLerpTarget", 99)) {
         this.F = var1.i("BorderSizeLerpTarget");
      }

      if(var1.b("BorderSafeZone", 99)) {
         this.G = var1.i("BorderSafeZone");
      }

      if(var1.b("BorderDamagePerBlock", 99)) {
         this.H = var1.i("BorderDamagePerBlock");
      }

      if(var1.b("BorderWarningBlocks", 99)) {
         this.I = var1.f("BorderWarningBlocks");
      }

      if(var1.b("BorderWarningTime", 99)) {
         this.J = var1.f("BorderWarningTime");
      }

   }

   public bqo(arb var1, String var2) {
      this.c = are.b;
      this.d = "";
      this.B = 0.0D;
      this.C = 0.0D;
      this.D = 6.0E7D;
      this.E = 0L;
      this.F = 0.0D;
      this.G = 5.0D;
      this.H = 0.2D;
      this.I = 5;
      this.J = 15;
      this.K = new aqq();
      this.a(var1);
      this.n = var2;
      this.z = a;
      this.y = false;
   }

   public void a(arb var1) {
      this.b = var1.d();
      this.u = var1.e();
      this.v = var1.g();
      this.w = var1.f();
      this.c = var1.h();
      this.d = var1.j();
      this.x = var1.i();
   }

   public bqo(bqo var1) {
      this.c = are.b;
      this.d = "";
      this.B = 0.0D;
      this.C = 0.0D;
      this.D = 6.0E7D;
      this.E = 0L;
      this.F = 0.0D;
      this.G = 5.0D;
      this.H = 0.2D;
      this.I = 5;
      this.J = 15;
      this.K = new aqq();
      this.b = var1.b;
      this.c = var1.c;
      this.d = var1.d;
      this.u = var1.u;
      this.v = var1.v;
      this.e = var1.e;
      this.f = var1.f;
      this.g = var1.g;
      this.h = var1.h;
      this.i = var1.i;
      this.j = var1.j;
      this.k = var1.k;
      this.l = var1.l;
      this.m = var1.m;
      this.n = var1.n;
      this.o = var1.o;
      this.r = var1.r;
      this.q = var1.q;
      this.t = var1.t;
      this.s = var1.s;
      this.w = var1.w;
      this.x = var1.x;
      this.y = var1.y;
      this.K = var1.K;
      this.z = var1.z;
      this.A = var1.A;
      this.B = var1.B;
      this.C = var1.C;
      this.D = var1.D;
      this.E = var1.E;
      this.F = var1.F;
      this.G = var1.G;
      this.H = var1.H;
      this.J = var1.J;
      this.I = var1.I;
   }

   public fn a() {
      fn var1 = new fn();
      this.a(var1, this.l);
      return var1;
   }

   public fn a(fn var1) {
      fn var2 = new fn();
      this.a(var2, var1);
      return var2;
   }

   private void a(fn var1, fn var2) {
      var1.a("RandomSeed", this.b);
      var1.a("generatorName", this.c.a());
      var1.a("generatorVersion", this.c.d());
      var1.a("generatorOptions", this.d);
      var1.a("GameType", this.u.a());
      var1.a("MapFeatures", this.v);
      var1.a("SpawnX", this.e);
      var1.a("SpawnY", this.f);
      var1.a("SpawnZ", this.g);
      var1.a("Time", this.h);
      var1.a("DayTime", this.i);
      var1.a("SizeOnDisk", this.k);
      var1.a("LastPlayed", MinecraftServer.ax());
      var1.a("LevelName", this.n);
      var1.a("version", this.o);
      var1.a("clearWeatherTime", this.p);
      var1.a("rainTime", this.r);
      var1.a("raining", this.q);
      var1.a("thunderTime", this.t);
      var1.a("thundering", this.s);
      var1.a("hardcore", this.w);
      var1.a("allowCommands", this.x);
      var1.a("initialized", this.y);
      var1.a("BorderCenterX", this.B);
      var1.a("BorderCenterZ", this.C);
      var1.a("BorderSize", this.D);
      var1.a("BorderSizeLerpTime", this.E);
      var1.a("BorderSafeZone", this.G);
      var1.a("BorderDamagePerBlock", this.H);
      var1.a("BorderSizeLerpTarget", this.F);
      var1.a("BorderWarningBlocks", (double)this.I);
      var1.a("BorderWarningTime", (double)this.J);
      if(this.z != null) {
         var1.a("Difficulty", (byte)this.z.a());
      }

      var1.a("DifficultyLocked", this.A);
      var1.a("GameRules", (gd)this.K.a());
      if(var2 != null) {
         var1.a("Player", (gd)var2);
      }

   }

   public long b() {
      return this.b;
   }

   public int c() {
      return this.e;
   }

   public int d() {
      return this.f;
   }

   public int e() {
      return this.g;
   }

   public long f() {
      return this.h;
   }

   public long g() {
      return this.i;
   }

   public fn i() {
      return this.l;
   }

   public void b(long var1) {
      this.h = var1;
   }

   public void c(long var1) {
      this.i = var1;
   }

   public void a(dt var1) {
      this.e = var1.n();
      this.f = var1.o();
      this.g = var1.p();
   }

   public String k() {
      return this.n;
   }

   public void a(String var1) {
      this.n = var1;
   }

   public int l() {
      return this.o;
   }

   public void e(int var1) {
      this.o = var1;
   }

   public int A() {
      return this.p;
   }

   public void i(int var1) {
      this.p = var1;
   }

   public boolean n() {
      return this.s;
   }

   public void a(boolean var1) {
      this.s = var1;
   }

   public int o() {
      return this.t;
   }

   public void f(int var1) {
      this.t = var1;
   }

   public boolean p() {
      return this.q;
   }

   public void b(boolean var1) {
      this.q = var1;
   }

   public int q() {
      return this.r;
   }

   public void g(int var1) {
      this.r = var1;
   }

   public arc r() {
      return this.u;
   }

   public boolean s() {
      return this.v;
   }

   public void f(boolean var1) {
      this.v = var1;
   }

   public void a(arc var1) {
      this.u = var1;
   }

   public boolean t() {
      return this.w;
   }

   public void g(boolean var1) {
      this.w = var1;
   }

   public are u() {
      return this.c;
   }

   public void a(are var1) {
      this.c = var1;
   }

   public String B() {
      return this.d;
   }

   public boolean v() {
      return this.x;
   }

   public void c(boolean var1) {
      this.x = var1;
   }

   public boolean w() {
      return this.y;
   }

   public void d(boolean var1) {
      this.y = var1;
   }

   public aqq x() {
      return this.K;
   }

   public double C() {
      return this.B;
   }

   public double D() {
      return this.C;
   }

   public double E() {
      return this.D;
   }

   public void a(double var1) {
      this.D = var1;
   }

   public long F() {
      return this.E;
   }

   public void e(long var1) {
      this.E = var1;
   }

   public double G() {
      return this.F;
   }

   public void b(double var1) {
      this.F = var1;
   }

   public void c(double var1) {
      this.C = var1;
   }

   public void d(double var1) {
      this.B = var1;
   }

   public double H() {
      return this.G;
   }

   public void e(double var1) {
      this.G = var1;
   }

   public double I() {
      return this.H;
   }

   public void f(double var1) {
      this.H = var1;
   }

   public int J() {
      return this.I;
   }

   public int K() {
      return this.J;
   }

   public void j(int var1) {
      this.I = var1;
   }

   public void k(int var1) {
      this.J = var1;
   }

   public vt y() {
      return this.z;
   }

   public void a(vt var1) {
      this.z = var1;
   }

   public boolean z() {
      return this.A;
   }

   public void e(boolean var1) {
      this.A = var1;
   }

   public void a(j var1) {
      var1.a("Level seed", (Callable)(new bqp(this)));
      var1.a("Level generator", (Callable)(new bqq(this)));
      var1.a("Level generator options", (Callable)(new bqr(this)));
      var1.a("Level spawn location", (Callable)(new bqs(this)));
      var1.a("Level time", (Callable)(new bqt(this)));
      var1.a("Level dimension", (Callable)(new bqu(this)));
      var1.a("Level storage version", (Callable)(new bqv(this)));
      var1.a("Level weather", (Callable)(new bqw(this)));
      var1.a("Level game mode", (Callable)(new bqx(this)));
   }

   // $FF: synthetic method
   static are a(bqo var0) {
      return var0.c;
   }

   // $FF: synthetic method
   static boolean b(bqo var0) {
      return var0.v;
   }

   // $FF: synthetic method
   static String c(bqo var0) {
      return var0.d;
   }

   // $FF: synthetic method
   static int d(bqo var0) {
      return var0.e;
   }

   // $FF: synthetic method
   static int e(bqo var0) {
      return var0.f;
   }

   // $FF: synthetic method
   static int f(bqo var0) {
      return var0.g;
   }

   // $FF: synthetic method
   static long g(bqo var0) {
      return var0.h;
   }

   // $FF: synthetic method
   static long h(bqo var0) {
      return var0.i;
   }

   // $FF: synthetic method
   static int i(bqo var0) {
      return var0.m;
   }

   // $FF: synthetic method
   static int j(bqo var0) {
      return var0.o;
   }

   // $FF: synthetic method
   static int k(bqo var0) {
      return var0.r;
   }

   // $FF: synthetic method
   static boolean l(bqo var0) {
      return var0.q;
   }

   // $FF: synthetic method
   static int m(bqo var0) {
      return var0.t;
   }

   // $FF: synthetic method
   static boolean n(bqo var0) {
      return var0.s;
   }

   // $FF: synthetic method
   static arc o(bqo var0) {
      return var0.u;
   }

   // $FF: synthetic method
   static boolean p(bqo var0) {
      return var0.w;
   }

   // $FF: synthetic method
   static boolean q(bqo var0) {
      return var0.x;
   }

}
