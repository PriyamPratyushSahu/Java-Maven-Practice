package practice;

public class aa {
    public static void main(String[] args) {
        String ss = "Mission for Integrated Development of Horticulture (MIDH)\n" +
                "\n" +
                "Coordinated Programme on Horticulture Assessment and Management using geo-informatics (Project CHAMAN)\n" +
                "\n" +
                "National Food Security Mission (NFSM)\n" +
                "\n" +
                "NFSM on Makka and Jau\n" +
                "\n" +
                "NFSM on Nutri-Cereals\n" +
                "\n" +
                "National Mission on Oilseeds and Oil Palm (NMOOP)\n" +
                "\n" +
                "National Mission for Sustainable Agriculture (NMSA)\n" +
                "\n" +
                "Rainfed Area Development (RAD)\n" +
                "\n" +
                "National Bamboo Mission (NBM)\n" +
                "\n" +
                "Sub-mission on Agriculture Extension (SMAE)\n" +
                "\n" +
                "National e-Governance Plan on Agriculture (NeGP-A)\n" +
                "\n" +
                "Sub-Mission on Seeds and Planting Material (SMSP)\n" +
                "\n" +
                "Sub-Mission on Agricultural Mechanisation (SMAM)\n" +
                "\n" +
                "Sub Mission on Plant Protection and Plant Quarantine (SMPPQ)\n" +
                "\n" +
                "Integrated Scheme on Agriculture Census, Economics and Statistics (ISACES)\n" +
                "\n" +
                "Integrated Scheme on Agricultural Cooperation (ISAC)\n" +
                "\n" +
                "Integrated Scheme on Agricultural Marketing (ISAM)";
        String ss1[] = ss.split("\n");
        for(int i = 0; i < ss1.length; i+= 2)
            System.out.println(ss1[i]);

    }
}
