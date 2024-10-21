package com.example.ttkg.board.entity;

public enum BoardCategory {
    ALL, FREE, QNA, BABY;

    public static BoardCategory of(String category){
        if(category.equalsIgnoreCase("all")) return BoardCategory.ALL;
        else if(category.equalsIgnoreCase("free")) return BoardCategory.FREE;
        else if(category.equalsIgnoreCase("qna")) return BoardCategory.QNA;
        else if(category.equalsIgnoreCase("baby")) return BoardCategory.BABY;
        else return null;
    }
}
