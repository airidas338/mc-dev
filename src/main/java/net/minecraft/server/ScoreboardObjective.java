package net.minecraft.server;

public class ScoreboardObjective {

   private final Scoreboard a;
   private final String b;
   private final IScoreboardCriteria c;
   private EnumObjectiveValue d;
   private String e;


   public ScoreboardObjective(Scoreboard var1, String var2, IScoreboardCriteria var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.e = var2;
      this.d = var3.c();
   }

   public String getName() {
      return this.b;
   }

   public IScoreboardCriteria getCriteria() {
      return this.c;
   }

   public String getDisplayName() {
      return this.e;
   }

   public void setDisplayName(String var1) {
      this.e = var1;
      this.a.handleObjectiveChanged(this);
   }

   public EnumObjectiveValue e() {
      return this.d;
   }

   public void a(EnumObjectiveValue var1) {
      this.d = var1;
      this.a.handleObjectiveChanged(this);
   }
}
