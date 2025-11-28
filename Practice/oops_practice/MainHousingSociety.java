
// ========================= ENUMERATIONS =========================

enum PlotType {
    RES_5_MARLA(4_000_000, "5 Marla Residential"),
    RES_10_MARLA(7_500_000, "10 Marla Residential"),
    RES_1_KANAL(14_000_000, "1 Kanal Residential"),
    COMM_SHOP(3_000_000, "Commercial Shop"),
    COMM_OFFICE(5_000_000, "Commercial Office"),
    PARKING(200_000, "Parking Space");
    
    private final double basePrice;
    private final String description;
    
    PlotType(double basePrice, String description) {
        this.basePrice = basePrice;
        this.description = description;
    }
    
    public double getBasePrice() {
        return basePrice;
    }
    
    public String getDescription() {
        return description;
    }
}

enum ShapeType {
    RECTANGLE,
    TRAPEZOID,
    L_SHAPE
}

// ========================= PLOT CLASS =========================

class Plot {
    protected String plotId;
    protected PlotType type;
    protected ShapeType shape;
    protected double[] dimensions;
    protected double area;
    protected double price;
    protected boolean available;
    
    public Plot(String plotId, PlotType type, ShapeType shape, double[] dimensions) {
        this.plotId = plotId;
        this.type = type;
        this.shape = shape;
        this.dimensions = dimensions;
        this.area = computeArea();
        this.price = type.getBasePrice();
        this.available = true;
    }
    
    protected double computeArea() {
        switch (shape) {
            case RECTANGLE:
                return dimensions[0] * dimensions[1]; // width × depth
            case TRAPEZOID:
                return ((dimensions[0] + dimensions[1]) / 2.0) * dimensions[2]; // ((front + back) / 2) × depth
            case L_SHAPE:
                return (dimensions[0] * dimensions[1]) + (dimensions[2] * dimensions[3]); // (w1 × d1) + (w2 × d2)
            default:
                return 0;
        }
    }
    
    public boolean book() {
        if (available) {
            available = false;
            return true;
        }
        return false;
    }
    
    public boolean cancel() {
        if (!available) {
            available = true;
            return true;
        }
        return false;
    }
    
    public String getPlotId() {
        return plotId;
    }
    
    public PlotType getType() {
        return type;
    }
    
    public double getArea() {
        return area;
    }
    
    public double getPrice() {
        return price;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    public String getAvailabilityMarker() {
        return available ? "A" : "X";
    }
    
    @Override
    public String toString() {
        return String.format("Plot %s | %s | %s | %.0f su | PKR %.0f | %s",
            plotId, type.name(), shape.name(), area, price, 
            available ? "AVAILABLE" : "BOOKED");
    }
}

// ========================= CORNER PLOT CLASS =========================

class CornerPlot extends Plot {
    private static final double CORNER_PREMIUM = 0.08; // 8%
    private double secondWidth;
    
    public CornerPlot(String plotId, PlotType type, ShapeType shape, double[] dimensions, double secondWidth) {
        super(plotId, type, shape, dimensions);
        this.secondWidth = secondWidth;
        this.area = computeArea();
        this.price = type.getBasePrice() * (1 + CORNER_PREMIUM);
    }
    
    @Override
    protected double computeArea() {
        // For corner plots, use dual frontage in area calculation
        if (shape == ShapeType.RECTANGLE) {
            return (dimensions[0] + secondWidth) * dimensions[1] / 2.0;
        }
        return super.computeArea();
    }
    
    @Override
    public String toString() {
        return String.format("Plot %s | %s CORNER | %s | %.0f su | PKR %.0f (+8%%) | %s",
            plotId, type.name(), shape.name(), area, price, 
            available ? "AVAILABLE" : "BOOKED");
    }
}

// ========================= PARK CLASS =========================

class Park {
    private String parkName;
    private ShapeType shape;
    private double[] dimensions;
    private double area;
    
    public Park(String parkName, ShapeType shape, double[] dimensions) {
        this.parkName = parkName;
        this.shape = shape;
        this.dimensions = dimensions;
        this.area = computeArea();
    }
    
    private double computeArea() {
        if (shape == ShapeType.RECTANGLE) {
            return dimensions[0] * dimensions[1];
        }
        return 0;
    }
    
    public String getParkName() {
        return parkName;
    }
    
    public double getArea() {
        return area;
    }
    
    @Override
    public String toString() {
        return String.format("%s (%s, %.0f su)", parkName, shape.name(), area);
    }
}

// ========================= SHOP CLASS =========================

class Shop {
    private String shopId;
    private double price;
    private boolean available;
    
    public Shop(String shopId) {
        this.shopId = shopId;
        this.price = PlotType.COMM_SHOP.getBasePrice();
        this.available = true;
    }
    
    public boolean book() {
        if (available) {
            available = false;
            return true;
        }
        return false;
    }
    
    public boolean cancel() {
        if (!available) {
            available = true;
            return true;
        }
        return false;
    }
    
    public String getShopId() {
        return shopId;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    @Override
    public String toString() {
        return String.format("Shop %s | PKR %.0f | %s", 
            shopId, price, available ? "AVAILABLE" : "BOOKED");
    }
}

// ========================= COMMERCIAL MARKET CLASS =========================

class CommercialMarket {
    private String marketName;
    private Shop[] shops;
    private int shopCount;
    
    public CommercialMarket(String marketName, int numberOfShops) {
        this.marketName = marketName;
        this.shops = new Shop[numberOfShops];
        this.shopCount = 0;
        
        // Initialize shops
        for (int i = 0; i < numberOfShops; i++) {
            addShop(new Shop(String.format("S-%03d", i + 1)));
        }
    }
    
    public void addShop(Shop shop) {
        if (shopCount < shops.length) {
            shops[shopCount++] = shop;
        }
    }
    
    public Shop[] getVacantShops() {
        // Two-pass filtering
        int count = 0;
        for (int i = 0; i < shopCount; i++) {
            if (shops[i].isAvailable()) {
                count++;
            }
        }
        
        Shop[] vacant = new Shop[count];
        int index = 0;
        for (int i = 0; i < shopCount; i++) {
            if (shops[i].isAvailable()) {
                vacant[index++] = shops[i];
            }
        }
        return vacant;
    }
    
    public int getTotalShops() {
        return shopCount;
    }
    
    public String getMarketName() {
        return marketName;
    }
    
    @Override
    public String toString() {
        int vacant = getVacantShops().length;
        return String.format("%s | Total Shops: %d | Vacant: %d", 
            marketName, shopCount, vacant);
    }
}

// ========================= BLOCK CLASS =========================

class Block {
    private String blockName;
    private Plot[][] plots; // Jagged 2D array
    private Park[] parks;
    private int parkCount;
    private CommercialMarket market;
    
    private static final int[] STREET_LENGTHS = {10, 11, 12, 13, 14};
    
    public Block(String blockName) {
        this.blockName = blockName;
        this.parks = new Park[2];
        this.parkCount = 0;
        this.market = new CommercialMarket(blockName + " Market", 15);
        
        initializePlots();
        initializeAmenities();
    }
    
    private void initializePlots() {
        plots = new Plot[5][];
        
        for (int street = 0; street < 5; street++) {
            plots[street] = new Plot[STREET_LENGTHS[street]];
            
            PlotType streetType = getStreetType(street + 1);
            ShapeType streetShape = getStreetShape(street + 1);
            
            for (int plotNum = 0; plotNum < STREET_LENGTHS[street]; plotNum++) {
                String plotId = String.format("%d-%03d", street + 1, plotNum + 1);
                
                // Every 5th plot becomes PARKING
                PlotType type = ((plotNum + 1) % 5 == 0) ? PlotType.PARKING : streetType;
                ShapeType shape = (type == PlotType.PARKING) ? ShapeType.RECTANGLE : streetShape;
                
                // Generate appropriate dimensions
                double[] dims = generateDimensions(shape, type);
                
                // Every 4th plot on streets 1-3 becomes CornerPlot
                if (street < 3 && (plotNum + 1) % 4 == 0 && type != PlotType.PARKING) {
                    plots[street][plotNum] = new CornerPlot(plotId, type, shape, dims, dims[0] * 0.5);
                } else {
                    plots[street][plotNum] = new Plot(plotId, type, shape, dims);
                }
            }
        }
    }
    
    private PlotType getStreetType(int street) {
        switch (street) {
            case 1: return PlotType.RES_5_MARLA;
            case 2: return PlotType.RES_10_MARLA;
            case 3: return PlotType.RES_1_KANAL;
            case 4: return PlotType.COMM_SHOP;
            case 5: return PlotType.COMM_OFFICE;
            default: return PlotType.RES_5_MARLA;
        }
    }
    
    private ShapeType getStreetShape(int street) {
        switch (street) {
            case 1: return ShapeType.RECTANGLE;
            case 2: return ShapeType.RECTANGLE;
            case 3: return ShapeType.TRAPEZOID;
            case 4: return ShapeType.RECTANGLE;
            case 5: return ShapeType.RECTANGLE;
            default: return ShapeType.RECTANGLE;
        }
    }
    
    private double[] generateDimensions(ShapeType shape, PlotType type) {
        switch (shape) {
            case RECTANGLE:
                if (type == PlotType.RES_5_MARLA) return new double[]{25, 50};
                if (type == PlotType.RES_10_MARLA) return new double[]{35, 70};
                if (type == PlotType.COMM_SHOP) return new double[]{20, 40};
                if (type == PlotType.COMM_OFFICE) return new double[]{30, 50};
                if (type == PlotType.PARKING) return new double[]{10, 20};
                return new double[]{30, 60};
            case TRAPEZOID:
                return new double[]{40, 50, 60}; // front, back, depth for 1 Kanal
            case L_SHAPE:
                return new double[]{30, 40, 20, 30};
            default:
                return new double[]{30, 60};
        }
    }
    
    private void initializeAmenities() {
        // Add parks
        parks[parkCount++] = new Park(blockName + " Park 1", ShapeType.RECTANGLE, new double[]{100, 150});
        parks[parkCount++] = new Park(blockName + " Park 2", ShapeType.RECTANGLE, new double[]{80, 120});
    }
    
    public boolean bookPlot(String plotId) {
        Plot plot = findPlot(plotId);
        if (plot != null) {
            return plot.book();
        }
        return false;
    }
    
    public boolean cancelPlot(String plotId) {
        Plot plot = findPlot(plotId);
        if (plot != null) {
            return plot.cancel();
        }
        return false;
    }
    
    public Plot findPlot(String plotId) {
        for (int street = 0; street < plots.length; street++) {
            for (int plotNum = 0; plotNum < plots[street].length; plotNum++) {
                if (plots[street][plotNum].getPlotId().equals(plotId)) {
                    return plots[street][plotNum];
                }
            }
        }
        return null;
    }
    
    public int getTotalPlots() {
        int total = 0;
        for (int street = 0; street < plots.length; street++) {
            total += plots[street].length;
        }
        return total;
    }
    
    public int getAvailablePlots() {
        int count = 0;
        for (int street = 0; street < plots.length; street++) {
            for (int plotNum = 0; plotNum < plots[street].length; plotNum++) {
                if (plots[street][plotNum].isAvailable()) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public Plot[] getPlotsByType(PlotType type) {
        // Two-pass filtering
        int count = 0;
        for (int street = 0; street < plots.length; street++) {
            for (int plotNum = 0; plotNum < plots[street].length; plotNum++) {
                if (plots[street][plotNum].getType() == type) {
                    count++;
                }
            }
        }
        
        Plot[] filtered = new Plot[count];
        int index = 0;
        for (int street = 0; street < plots.length; street++) {
            for (int plotNum = 0; plotNum < plots[street].length; plotNum++) {
                if (plots[street][plotNum].getType() == type) {
                    filtered[index++] = plots[street][plotNum];
                }
            }
        }
        return filtered;
    }
    
    public String getBlockName() {
        return blockName;
    }
    
    public Plot[][] getPlots() {
        return plots;
    }
    
    public void printLayout() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("BLOCK: " + blockName);
        System.out.println("=".repeat(60));
        System.out.println("Total Plots: " + getTotalPlots() + " | Available: " + getAvailablePlots());
        System.out.println("-".repeat(60));
        
        for (int street = 0; street < plots.length; street++) {
            System.out.printf("Street %d: ", street + 1);
            for (int plotNum = 0; plotNum < plots[street].length; plotNum++) {
                System.out.print(plots[street][plotNum].getPlotId() + 
                    "(" + plots[street][plotNum].getAvailabilityMarker() + ") ");
            }
            System.out.println();
        }
    }
    
    public void printDetailedPlots() {
        System.out.println("\n--- Detailed Plot Information ---");
        for (int street = 0; street < plots.length; street++) {
            System.out.println("\nStreet " + (street + 1) + ":");
            for (int plotNum = 0; plotNum < plots[street].length; plotNum++) {
                System.out.println("  " + plots[street][plotNum]);
            }
        }
    }
    
    public void printAmenities() {
        System.out.println("\n--- Amenities ---");
        System.out.println("Parks:");
        for (int i = 0; i < parkCount; i++) {
            System.out.println("  " + parks[i]);
        }
        System.out.println("\nCommercial Market:");
        System.out.println("  " + market);
    }
    
    public CommercialMarket getMarket() {
        return market;
    }
}

// ========================= HOUSING SOCIETY CLASS =========================

class HousingSociety {
    private String societyName;
    private Block[] blocks;
    private int blockCount;
    private int maxBlocks;
    
    public HousingSociety(String societyName) {
        this.societyName = societyName;
        this.maxBlocks = 5;
        this.blocks = new Block[maxBlocks];
        this.blockCount = 0;
        
        // Preload default blocks A, B, C
        addBlock(new Block("Block A"));
        addBlock(new Block("Block B"));
        addBlock(new Block("Block C"));
    }
    
    public void addBlock(Block block) {
        if (blockCount >= maxBlocks) {
            growBlockArray();
        }
        blocks[blockCount++] = block;
    }
    
    private void growBlockArray() {
        maxBlocks *= 2;
        Block[] newBlocks = new Block[maxBlocks];
        for (int i = 0; i < blockCount; i++) {
            newBlocks[i] = blocks[i];
        }
        blocks = newBlocks;
    }
    
    public Block findBlock(String blockName) {
        for (int i = 0; i < blockCount; i++) {
            if (blocks[i].getBlockName().equalsIgnoreCase(blockName)) {
                return blocks[i];
            }
        }
        return null;
    }
    
    public boolean bookPlot(String blockName, String plotId) {
        Block block = findBlock(blockName);
        if (block != null) {
            return block.bookPlot(plotId);
        }
        return false;
    }
    
    public boolean cancelBooking(String blockName, String plotId) {
        Block block = findBlock(blockName);
        if (block != null) {
            return block.cancelPlot(plotId);
        }
        return false;
    }
    
    public int getTotalPlots() {
        int total = 0;
        for (int i = 0; i < blockCount; i++) {
            total += blocks[i].getTotalPlots();
        }
        return total;
    }
    
    public int getAvailablePlots() {
        int total = 0;
        for (int i = 0; i < blockCount; i++) {
            total += blocks[i].getAvailablePlots();
        }
        return total;
    }
    
    public Plot findFirstAvailableKanalCorner() {
        for (int i = 0; i < blockCount; i++) {
            Plot[][] plots = blocks[i].getPlots();
            for (int street = 0; street < plots.length; street++) {
                for (int plotNum = 0; plotNum < plots[street].length; plotNum++) {
                    Plot plot = plots[street][plotNum];
                    if (plot instanceof CornerPlot && 
                        plot.getType() == PlotType.RES_1_KANAL && 
                        plot.isAvailable()) {
                        return plot;
                    }
                }
            }
        }
        return null;
    }
    
    public Plot findLargestResidentialPlot() {
        Plot largest = null;
        double maxArea = 0;
        
        for (int i = 0; i < blockCount; i++) {
            Plot[][] plots = blocks[i].getPlots();
            for (int street = 0; street < plots.length; street++) {
                for (int plotNum = 0; plotNum < plots[street].length; plotNum++) {
                    Plot plot = plots[street][plotNum];
                    if (plot.isAvailable() && 
                        (plot.getType() == PlotType.RES_5_MARLA || 
                         plot.getType() == PlotType.RES_10_MARLA || 
                         plot.getType() == PlotType.RES_1_KANAL) &&
                        plot.getArea() > maxArea) {
                        largest = plot;
                        maxArea = plot.getArea();
                    }
                }
            }
        }
        return largest;
    }
    
    public String getSocietyName() {
        return societyName;
    }
    
    public Block[] getBlocks() {
        Block[] result = new Block[blockCount];
        for (int i = 0; i < blockCount; i++) {
            result[i] = blocks[i];
        }
        return result;
    }
    
    public void printSummary() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("HOUSING SOCIETY: " + societyName);
        System.out.println("=".repeat(80));
        System.out.println("Total Blocks: " + blockCount);
        System.out.println("Total Plots: " + getTotalPlots());
        System.out.println("Available Plots: " + getAvailablePlots());
        System.out.println("-".repeat(80));
        
        for (int i = 0; i < blockCount; i++) {
            Block block = blocks[i];
            System.out.printf("%s: %d plots (%d available)\n", 
                block.getBlockName(), block.getTotalPlots(), block.getAvailablePlots());
        }
    }
}

// ========================= CITY HOUSING CLASS =========================

class CityHousing {
    private String cityName;
    private HousingSociety[] societies;
    private int societyCount;
    private int maxSocieties;
    
    public CityHousing(String cityName) {
        this.cityName = cityName;
        this.maxSocieties = 5;
        this.societies = new HousingSociety[maxSocieties];
        this.societyCount = 0;
        
        // Preload LDA Avenue 1 and LDA Avenue 2
        addSociety(new HousingSociety("LDA Avenue 1"));
        addSociety(new HousingSociety("LDA Avenue 2"));
    }
    
    public void addSociety(HousingSociety society) {
        if (societyCount >= maxSocieties) {
            growSocietyArray();
        }
        societies[societyCount++] = society;
    }
    
    private void growSocietyArray() {
        maxSocieties *= 2;
        HousingSociety[] newSocieties = new HousingSociety[maxSocieties];
        for (int i = 0; i < societyCount; i++) {
            newSocieties[i] = societies[i];
        }
        societies = newSocieties;
    }
    
    public boolean removeSociety(String societyName) {
        for (int i = 0; i < societyCount; i++) {
            if (societies[i].getSocietyName().equalsIgnoreCase(societyName)) {
                // Shift elements
                for (int j = i; j < societyCount - 1; j++) {
                    societies[j] = societies[j + 1];
                }
                societies[--societyCount] = null;
                return true;
            }
        }
        return false;
    }
    
    public HousingSociety findSociety(String societyName) {
        for (int i = 0; i < societyCount; i++) {
            if (societies[i].getSocietyName().equalsIgnoreCase(societyName)) {
                return societies[i];
            }
        }
        return null;
    }
    
    public boolean bookPlot(String societyName, String blockName, String plotId) {
        HousingSociety society = findSociety(societyName);
        if (society != null) {
            return society.bookPlot(blockName, plotId);
        }
        return false;
    }
    
    public boolean cancelBooking(String societyName, String blockName, String plotId) {
        HousingSociety society = findSociety(societyName);
        if (society != null) {
            return society.cancelBooking(blockName, plotId);
        }
        return false;
    }
    
    public int getTotalStudentsInUniversity() {
        int total = 0;
        for (int i = 0; i < societyCount; i++) {
            total += societies[i].getTotalPlots();
        }
        return total;
    }
    
    public String findFirstAvailableKanalCorner() {
        for (int i = 0; i < societyCount; i++) {
            Plot plot = societies[i].findFirstAvailableKanalCorner();
            if (plot != null) {
                // Find which block contains this plot
                for (Block block : societies[i].getBlocks()) {
                    if (block.findPlot(plot.getPlotId()) != null) {
                        return String.format("%s > %s > Plot %s (%s CORNER, area %.0f su, PKR %.0f)",
                            societies[i].getSocietyName(), block.getBlockName(),
                            plot.getPlotId(), plot.getType().name(), 
                            plot.getArea(), plot.getPrice());
                    }
                }
            }
        }
        return "No available RES_1_KANAL CornerPlot found";
    }
    
    public void printCitySummary() {
        System.out.println("\n" + "=".repeat(100));
        System.out.println("CITY HOUSING: " + cityName);
        System.out.println("=".repeat(100));
        System.out.println("Total Societies: " + societyCount);
        
        for (int i = 0; i < societyCount; i++) {
            societies[i].printSummary();
        }
    }
    
    public HousingSociety[] getSocieties() {
        HousingSociety[] result = new HousingSociety[societyCount];
        for (int i = 0; i < societyCount; i++) {
            result[i] = societies[i];
        }
        return result;
    }
}

// ========================= DEMO CLASSES =========================

class PlotDemo {
    public static void main(String[] args) {
        System.out.println("=== PLOT DEMO ===\n");
        
        // Test regular plot
        Plot regularPlot = new Plot("1-001", PlotType.RES_5_MARLA, 
            ShapeType.RECTANGLE, new double[]{25, 50});
        System.out.println("Regular Plot Created:");
        System.out.println(regularPlot);
        
        // Test corner plot
        CornerPlot cornerPlot = new CornerPlot("3-004", PlotType.RES_1_KANAL, 
            ShapeType.TRAPEZOID, new double[]{40, 50, 60}, 20);
        System.out.println("\nCorner Plot Created:");
        System.out.println(cornerPlot);
        
        // Test booking
        System.out.println("\n--- Testing Booking ---");
        System.out.println("Booking regular plot: " + regularPlot.book());
        System.out.println("After booking: " + regularPlot);
        System.out.println("Attempting to book again: " + regularPlot.book());
        
        // Test cancellation
        System.out.println("\n--- Testing Cancellation ---");
        System.out.println("Cancelling booking: " + regularPlot.cancel());
        System.out.println("After cancellation: " + regularPlot);
    }
}

class SocietyDemo {
    public static void main(String[] args) {
        System.out.println("=== HOUSING SOCIETY MANAGEMENT SYSTEM DEMO ===\n");
        
        // Create Lahore city housing
        CityHousing lahore = new CityHousing("Lahore");
        
        // Print initial summary
        lahore.printCitySummary();
        
        // Get LDA Avenue 1 and print detailed info for Block A
        HousingSociety lda1 = lahore.findSociety("LDA Avenue 1");
        if (lda1 != null) {
            Block blockA = lda1.findBlock("Block A");
            if (blockA != null) {
                blockA.printLayout();
                blockA.printDetailedPlots();
                blockA.printAmenities();
            }
        }
        
        // WORKFLOW DEMONSTRATION
        System.out.println("\n\n" + "=".repeat(100));
        System.out.println("WORKFLOW DEMONSTRATION");
        System.out.println("=".repeat(100));
        
        // 1. Book plot 3-007 in LDA Avenue 1, Block A
        System.out.println("\n1. Booking plot 3-007 in LDA Avenue 1, Block A:");
        boolean booked = lahore.bookPlot("LDA Avenue 1", "Block A", "3-007");
        System.out.println("   Booking status: " + (booked ? "SUCCESS" : "FAILED"));
        
        // 2. Attempt to book same plot again
        System.out.println("\n2. Attempting to book 3-007 again:");
        booked = lahore.bookPlot("LDA Avenue 1", "Block A", "3-007");
        System.out.println("   Booking status: " + (booked ? "SUCCESS" : "FAILED (Expected)"));
        
        // 3. Cancel the booking
        System.out.println("\n3. Cancelling booking for plot 3-007:");
        boolean cancelled = lahore.cancelBooking("LDA Avenue 1", "Block A", "3-007");
        System.out.println("   Cancellation status: " + (cancelled ? "SUCCESS" : "FAILED"));
        
        // 4. Print street 3 layout to confirm state change
        System.out.println("\n4. Street 3 layout after cancellation:");
        if (lda1 != null) {
            Block blockA = lda1.findBlock("Block A");
            if (blockA != null) {
                Plot[][] plots = blockA.getPlots();
                System.out.print("   Street 3: ");
                for (int i = 0; i < plots[2].length; i++) {
                    System.out.print(plots[2][i].getPlotId() + 
                        "(" + plots[2][i].getAvailabilityMarker() + ") ");
                }
                System.out.println();
            }
        }
        
        // 5. Search: Find first available RES_1_KANAL CornerPlot in LDA Avenue 2
        System.out.println("\n5. Searching for first available RES_1_KANAL CornerPlot in LDA Avenue 2:");
        HousingSociety lda2 = lahore.findSociety("LDA Avenue 2");
        if (lda2 != null) {
            Plot corner = lda2.findFirstAvailableKanalCorner();
            if (corner != null) {
                System.out.println("   Found: " + corner);
            } else {
                System.out.println("   Not found");
            }
        }
        
        // 6. List first 3 vacant shops in LDA Avenue 1, Block C market
        System.out.println("\n6. Main 3 vacant shops in LDA Avenue 1, Block C market:");
        if (lda1 != null) {
            Block blockC = lda1.findBlock("Block C");
            if (blockC != null) {
                Shop[] vacantShops = blockC.getMarket().getVacantShops();
                int count = Math.min(3, vacantShops.length);
                for (int i = 0; i < count; i++) {
                    System.out.println("   " + vacantShops[i]);
                }
            }
        }
        
        // 7. Find largest available residential plot
        System.out.println("\n7. Finding largest available residential plot in LDA Avenue 1:");
        if (lda1 != null) {
            Plot largest = lda1.findLargestResidentialPlot();
            if (largest != null) {
                System.out.println("   " + largest);
            }
        }
        
        // 8. Search across entire city
        System.out.println("\n8. City-wide search for RES_1_KANAL CornerPlot:");
        String result = lahore.findFirstAvailableKanalCorner();
        System.out.println("   " + result);
        
        // Final summary
        System.out.println("\n\n" + "=".repeat(100));
        System.out.println("FINAL CITY SUMMARY");
        System.out.println("=".repeat(100));
        lahore.printCitySummary();
        
        // Print detailed info for LDA Avenue 2, Block B
        System.out.println("\n\n" + "=".repeat(100));
        System.out.println("DETAILED VIEW: LDA Avenue 2, Block B");
        System.out.println("=".repeat(100));
        if (lda2 != null) {
            Block blockB = lda2.findBlock("Block B");
            if (blockB != null) {
                blockB.printLayout();
                blockB.printAmenities();
            }
        }
    }
}

// ========================= MAIN CLASS =========================

class MainHousingSociety {
    public static void main(String[] args) {
        // Run the comprehensive demo
        SocietyDemo.main(args);
        
        System.out.println("\n\n" + "=".repeat(100));
        System.out.println("ADDITIONAL DEMONSTRATIONS");
        System.out.println("=".repeat(100));
        
        // Create a custom city for additional testing
        CityHousing testCity = new CityHousing("Lahore");
        
        // Get societies
        HousingSociety lda1 = testCity.findSociety("LDA Avenue 1");
        HousingSociety lda2 = testCity.findSociety("LDA Avenue 2");
        
        // Test booking multiple plots
        System.out.println("\n--- Booking Multiple Plots ---");
        String[] plotsToBook = {"1-001", "1-004", "2-003", "3-007", "4-005"};
        
        for (String plotId : plotsToBook) {
            boolean success = testCity.bookPlot("LDA Avenue 1", "Block A", plotId);
            System.out.printf("Booking %s: %s\n", plotId, success ? "SUCCESS" : "FAILED");
        }
        
        // Show availability statistics by plot type
        System.out.println("\n--- Availability Statistics by Plot Type ---");
        if (lda1 != null) {
            Block blockA = lda1.findBlock("Block A");
            if (blockA != null) {
                PlotType[] types = {PlotType.RES_5_MARLA, PlotType.RES_10_MARLA, 
                    PlotType.RES_1_KANAL, PlotType.COMM_SHOP, PlotType.COMM_OFFICE};
                
                for (PlotType type : types) {
                    Plot[] plots = blockA.getPlotsByType(type);
                    int available = 0;
                    for (Plot p : plots) {
                        if (p.isAvailable()) available++;
                    }
                    System.out.printf("%s: %d total, %d available\n", 
                        type.name(), plots.length, available);
                }
            }
        }
        
        // Demonstrate corner plot premium
        System.out.println("\n--- Corner Plot Premium Demonstration ---");
        if (lda1 != null) {
            Block blockA = lda1.findBlock("Block A");
            if (blockA != null) {
                Plot[][] plots = blockA.getPlots();
                System.out.println("Street 3 (RES_1_KANAL) - Regular vs Corner Plots:");
                for (int i = 0; i < Math.min(8, plots[2].length); i++) {
                    Plot p = plots[2][i];
                    String type = (p instanceof CornerPlot) ? "CORNER" : "REGULAR";
                    System.out.printf("  %s [%s]: PKR %.0f, Area: %.0f su\n", 
                        p.getPlotId(), type, p.getPrice(), p.getArea());
                }
            }
        }
        
        // Demonstrate parking allocation
        System.out.println("\n--- Parking Allocation (Every 5th Plot) ---");
        if (lda2 != null) {
            Block blockA = lda2.findBlock("Block A");
            if (blockA != null) {
                Plot[] parkingPlots = blockA.getPlotsByType(PlotType.PARKING);
                System.out.println("Total Parking Spaces: " + parkingPlots.length);
                System.out.print("Parking Plot IDs: ");
                for (int i = 0; i < Math.min(10, parkingPlots.length); i++) {
                    System.out.print(parkingPlots[i].getPlotId() + " ");
                }
                System.out.println();
            }
        }
        
        // Test array growth by adding a new block
        System.out.println("\n--- Testing Dynamic Array Growth ---");
        if (lda1 != null) {
            System.out.println("Current blocks in LDA Avenue 1: " + lda1.getBlocks().length);
            Block newBlock = new Block("Block D");
            lda1.addBlock(newBlock);
            System.out.println("After adding Block D: " + lda1.getBlocks().length);
            System.out.println("New block total plots: " + newBlock.getTotalPlots());
        }
        
        // Show shape-based area calculations
        System.out.println("\n--- Shape-Based Area Calculations ---");
        System.out.println("RECTANGLE (5 Marla): 25 × 50 = 1,250 su");
        Plot rect = new Plot("TEST-1", PlotType.RES_5_MARLA, 
            ShapeType.RECTANGLE, new double[]{25, 50});
        System.out.println("Calculated: " + rect.getArea() + " su");
        
        System.out.println("\nTRAPEZOID (1 Kanal): ((40+50)/2) × 60 = 2,700 su");
        Plot trap = new Plot("TEST-2", PlotType.RES_1_KANAL, 
            ShapeType.TRAPEZOID, new double[]{40, 50, 60});
        System.out.println("Calculated: " + trap.getArea() + " su");
        
        System.out.println("\nL_SHAPE: (30×40) + (20×30) = 1,800 su");
        Plot lshape = new Plot("TEST-3", PlotType.RES_10_MARLA, 
            ShapeType.L_SHAPE, new double[]{30, 40, 20, 30});
        System.out.println("Calculated: " + lshape.getArea() + " su");
        
        // Commercial market operations
        System.out.println("\n--- Commercial Market Operations ---");
        if (lda1 != null) {
            Block blockB = lda1.findBlock("Block B");
            if (blockB != null) {
                CommercialMarket market = blockB.getMarket();
                System.out.println(market);
                
                // Book some shops
                Shop[] vacantShops = market.getVacantShops();
                if (vacantShops.length > 0) {
                    System.out.println("\nBooking first 3 shops:");
                    for (int i = 0; i < Math.min(3, vacantShops.length); i++) {
                        vacantShops[i].book();
                        System.out.println("  Booked: " + vacantShops[i].getShopId());
                    }
                    System.out.println("\nAfter booking: " + market);
                }
            }
        }
        
        // Final statistics
        System.out.println("\n\n" + "=".repeat(100));
        System.out.println("FINAL STATISTICS");
        System.out.println("=".repeat(100));
        
        for (HousingSociety society : testCity.getSocieties()) {
            System.out.println("\n" + society.getSocietyName() + ":");
            System.out.println("  Total Plots: " + society.getTotalPlots());
            System.out.println("  Available Plots: " + society.getAvailablePlots());
            System.out.println("  Occupancy Rate: " + 
                String.format("%.1f%%", 
                    (society.getTotalPlots() - society.getAvailablePlots()) * 100.0 / 
                    society.getTotalPlots()));
        }
        
        System.out.println("\n" + "=".repeat(100));
        System.out.println("END OF DEMONSTRATION");
        System.out.println("=".repeat(100));
    }
}

