package de.AlexOffiziell.RateMyPlot.FileManagement;

public enum InventoryItem {

    //TODO: Maybe create an array for each Item. The array stores the values like name, material and lore. -> Not sure!

    MATERIAL_BACKGROUND("Background_Material", (String) FileHolder.getInstance().items.getValue("VoteInventory.Background.Material")),
    MATERIAL_CURRENTLY_SELECTED("Selected_Material", (String) FileHolder.getInstance().items.getValue("VoteInventory.CurrentVote.Material")),
    MATERIAL_CURRENTLY_NOT_SELECTED("Not_Selected_Material", (String) FileHolder.getInstance().items.getValue("VoteInventory.StandardVote.Material")),
    MATERIAL_VOTE_CATEGORY_1("Vote_1_Material", (String) FileHolder.getInstance().items.getValue("VoteInventory.VoteCategory.1.Material")),
    MATERIAL_VOTE_CATEGORY_2("Vote_2_Material", (String) FileHolder.getInstance().items.getValue("VoteInventory.VoteCategory.2.Material")),
    MATERIAL_VOTE_CATEGORY_3("Vote_3_Material", (String) FileHolder.getInstance().items.getValue("VoteInventory.VoteCategory.3.Material")),
    MATERIAL_VOTE_CATEGORY_4("Vote_4_Material", (String) FileHolder.getInstance().items.getValue("VoteInventory.VoteCategory.4.Material"));



    private String name;
    private String value;

    InventoryItem(String name, String value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }
}
