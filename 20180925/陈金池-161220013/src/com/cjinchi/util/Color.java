package com.cjinchi.util;

public enum Color {
    RED("��ɫ"), ORANGE("��ɫ"), YELLOW("��ɫ"), GREEN("��ɫ"), CYAN("��ɫ"), BLUE("��ɫ"), VIOLET("��ɫ");

    private String label;

    private Color(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
