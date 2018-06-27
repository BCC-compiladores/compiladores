package gals;

public interface ParserConstants
{
    int START_SYMBOL = 45;

    int FIRST_NON_TERMINAL    = 45;
    int FIRST_SEMANTIC_ACTION = 93;

    int[][] PARSER_TABLE =
    {
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,   0,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  65,  65,  65,  65,  -1,  -1,  -1,  -1,  -1,  65,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  65,  -1,  -1,  -1,  -1,  65,  65,  -1,  -1,  -1,  65,  -1,  -1,  -1,  -1,  -1,  -1,  65,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  69,  69,  69,  69,  -1,  -1,  -1,  -1,  -1,  71,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  70,  -1,  -1,  -1,  -1,  69,  69,  -1,  -1,  -1,  69,  -1,  -1,  -1,  -1,  -1,  -1,  72,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  73,  73,  73,  73,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  73,  73,  -1,  -1,  -1,  73,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  76,  -1,  -1,  -1,  -1,  -1,  77,  78,  79,  80,  81 },
        {  -1,  82,  82,  82,  82,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  82,  82,  -1,  -1,  -1,  82,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  86,  86,  86,  86,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  86,  86,  -1,  -1,  -1,  86,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  90,  91,  92,  93,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  95,  96,  -1,  -1,  -1,  94,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,   2,  -1,  -1,   2,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,   1,   2,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,   3,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,   6,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,   7,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,   7,  -1,   7,   7,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,   7,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  10,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  11,  -1,  12,  12,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  13,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  20,  -1,  -1,  -1,  -1,  -1,  20,  -1,  -1,  -1,  -1,  20,  -1,  -1,  -1,  20,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  21,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  25,  -1,  -1,  -1,  -1,  -1,  23,  -1,  -1,  -1,  -1,  22,  -1,  -1,  -1,  24,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  26,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  27,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  30,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  33,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  36,  37,  38,  -1,  -1,  -1,  -1,  -1,  40,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  39,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  42,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  41,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  43,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  50,  -1,  -1,  -1,  49,  -1,  -1,  -1,  -1,  -1,  47,  -1,  -1,  -1,  -1,  46,  -1,  -1,  -1,  48,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  51,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  52,  53,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  54,  54,  54,  54,  -1,  -1,  -1,  -1,  -1,  54,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  54,  -1,  -1,  -1,  -1,  54,  54,  -1,  -1,  -1,  54,  -1,  -1,  -1,  -1,  -1,  -1,  54,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  64,  63,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  99,  -1,  -1,  -1,  -1,  -1,  -1,  -1, 100,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1, 100,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  31,  -1,  -1,  32,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  32,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,   4,  -1,  -1,  -1,  -1,   5,  -1,  -1,   5,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,   5,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {   9,   8,  -1,  -1,  -1,  -1,  -1,  -1,   9,  -1,  -1,  -1,  -1,   9,  -1,   8,  -1,   8,   8,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,   8,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  68,  68,  -1,  -1,  -1,  -1,  -1,  -1,  68,  -1,  -1,  -1,  -1,  68,  -1,  68,  -1,  68,  68,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  68,  68,  -1,  -1,  68,  66,  67,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  85,  85,  -1,  -1,  -1,  -1,  -1,  -1,  85,  -1,  -1,  -1,  -1,  85,  -1,  85,  -1,  85,  85,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  83,  84,  -1,  -1,  -1,  85,  85,  85,  -1,  85,  85,  85,  -1,  85,  85,  85,  85,  85 },
        {  89,  89,  -1,  -1,  -1,  -1,  -1,  -1,  89,  -1,  -1,  -1,  -1,  89,  -1,  89,  -1,  89,  89,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  89,  89,  87,  88,  -1,  89,  89,  89,  -1,  89,  89,  89,  -1,  89,  89,  89,  89,  89 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  15,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  14,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  18,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  19,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  59,  58,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  57,  57,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  62,  62,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  16,  16,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  17,  17,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  28,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  29,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  35,  -1,  35,  35,  -1,  34,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  44,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  45,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  56,  -1,  -1,  55,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  61,  -1,  -1,  -1,  -1,  60,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1 },
        {  75,  75,  -1,  -1,  -1,  -1,  -1,  -1,  75,  -1,  -1,  -1,  -1,  75,  -1,  75,  -1,  75,  75,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  75,  75,  74,  -1,  75,  75,  75,  -1,  74,  74,  74,  74,  74 },
        {  98,  98,  -1,  -1,  -1,  -1,  -1,  -1,  98,  -1,  -1,  -1,  97,  98,  -1,  98,  -1,  98,  98,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  98,  98,  98,  98,  -1,  98,  98,  98,  -1,  98,  98,  98,  -1,  98,  98,  98,  98,  98 }
    };

    int[][] PRODUCTIONS = 
    {
        { 108,   8,  53,  73,  65,  10,  56, 109 },
        {  23,  54 },
        {   0 },
        {  55,  74 },
        {  54 },
        {   0 },
        {   2,  31,  58 },
        {  57,  75 },
        {  56 },
        {   0 },
        {   2,  79 },
        {  68 },
        {  69 },
        { 120,  32,  46,  33,  85 },
        {  80 },
        {  81 },
        {  83 },
        {  84 },
        { 115,  35,  46, 119 },
        {  20,  32,   2,  36,  46,  33 },
        {  59 },
        {  60 },
        {  17 },
        {  12 },
        {  21 },
        {   6 },
        {  32,  61,  33 },
        {  62,  86 },
        {  61 },
        {   0 },
        {   2,  31,  59 },
        {   7,  63,  34,  64, 125,  72 },
        {   0 },
        {   2, 115,  87 },
        {  36,  63 },
        {   0 },
        {   3 },
        {   4 },
        {   5 },
        {  22 },
        {  11 },
        {  24,  66 },
        {   0 },
        {  63,  31,  67, 114, 116,  88 },
        {  66 },
        {   0 },
        {  17 },
        {  12 },
        {  21 },
        {   6 },
        {   2 },
        {  16,  32,  63, 117,  33 },
        {  18,  32,  70,  33 },
        {  19,  32,  70,  33, 110 },
        {  46, 107,  89 },
        {  36,  70 },
        {   0 },
        {  82 },
        {  15, 121,  31,  56,  90,   9, 122 },
        { 123,  14,  31,  56,   9, 122 },
        {  14, 121,  31,  56 },
        {   0 },
        {  71,  31,  56,   9, 124 },
        {  26, 121 },
        {  25, 121 },
        {  47,  76 },
        {  37,  47, 111,  76 },
        {  38,  47, 112,  76 },
        {   0 },
        {  48 },
        {  22, 104 },
        {  11, 105 },
        {  39,  47, 106 },
        {  50,  91 },
        {  49, 102,  50, 103 },
        {   0 },
        {  34 },
        {  40 },
        {  41 },
        {  42 },
        {  43 },
        {  44 },
        {  51,  77 },
        {  27,  51,  94,  77 },
        {  28,  51,  95,  77 },
        {   0 },
        {  52,  78 },
        {  29,  52,  96,  78 },
        {  30,  52,  97,  78 },
        {   0 },
        {   2, 118,  92 },
        {   3,  98 },
        {   4,  99 },
        {   5, 113 },
        {  32,  46,  33 },
        {  27,  52, 100 },
        {  28,  52, 101 },
        {  13,  32,   2,  33 },
        {   0 },
        {  63,  34,  64,  72 },
        {   0 }
    };

    String[] PARSER_ERROR =
    {
        "",
        "esperado fim de programa",
        "esperado identificador",
        "esperado constante int",
        "esperado constante float",
        "esperado constante str",
        "esperado bool",
        "esperado consts",
        "esperado def",
        "esperado end",
        "esperado execute",
        "esperado false",
        "esperado float",
        "esperado get",
        "esperado ifFalse",
        "esperado ifTrue",
        "esperado input",
        "esperado int",
        "esperado print",
        "esperado println",
        "esperado set",
        "esperado str",
        "esperado true",
        "esperado types",
        "esperado var",
        "esperado whileFalse",
        "esperado whileTrue",
        "esperado \"+\"",
        "esperado \"-\"",
        "esperado \"*\"",
        "esperado \"/\"",
        "esperado \":\"",
        "esperado \"(\"",
        "esperado \")\"",
        "esperado \"=\"",
        "esperado \":=\"",
        "esperado \",\"",
        "esperado \"&&\"",
        "esperado \"||\"",
        "esperado \"!\"",
        "esperado \"!=\"",
        "esperado \"<\"",
        "esperado \"<=\"",
        "esperado \">\"",
        "esperado \">=\"",
        "esperado def",//"<PROGRAMA> inválido",
        "esperada expressao ",//"<EXPRESSAO> inválido",
        "esperado expressao",//"<ELEMENTO> inválido",
        "esperado expressao",//"<RELACIONAL> inválido",
        "esperado expressao",//"<OPERADOR_RELACIONAL> inválido",
        "esperado expressao",//"<ARITMETICA> inválido",
        "esperado expressao",//"<TERMO> inválido",
        "esperado expressão",//"<FATOR> inválido",
        "esperado consts, execute, types, var",//"<DEFINICAO_DE_TIPOS> inválido",
        "esperado identificador",//"<TIPOS> inválido",
        "esperado identificador",//"<DEF_TIPO> inválido",
        "esperado comando",//"<LISTA_DE_COMANDOS> inválido",
        "esperado comando",//"<COMANDO> inválido",
        "esperado bool, float, int, str, (",//"<TIPO> inválido",
        "esperado bool, float, int, str ",//"<SIMPLES> inválido",
        "esperado (",//"<COMPOSTO> inválido",
        "esperado identificador ",//"<LISTA_DE_CAMPOS> inválido",
        "esperado identificador",//"<CAMPO> inválido",
        "esperado identificador ",//"<LISTA_DE_IDENTIFICADORES> inválido",
        "esperado constante int, constante float, constante str, false, true",//"<VALOR> inválido",
        "esperado var, execute, ",//"<DECLARACAO_DE_VARIAVEIS> inválido",
        "esperado identificador, ",//"<DEC_VAR> inválido",
        "esperado identificador, bool, float, int, str",//"<TIPO_VAR> inválido",
        "esperado input",//"<ENTRADA_DADOS> inválido",
        "esperado print, println",//"<SAIDA_DADOS> inválido",
        "esperado expressão",//"<LISTA_DE_EXPRESSOES> inválido",
        "esperado whileTrue, whileFalse",//"<WHILE> inválido",
        "esperado identificador, execute, var",//"<REP_CONSTS> inválido",
        "esperado consts, execute, var",//"<DEFINICAO_DE_CONSTANTES> inválido",
        "esperado identificador, consts, execute, var",//"<TIPOS1> inválido",
        "esperado comando, fim de programa, end, ifFalse",//"<LISTA_DE_COMANDOS1> inválido",
        "esperado expressao",//"<EXPRESSAO1> inválido",
        "esperado expressao",//"<ARITMETICA1> inválido",
        "esperado expressao",//"<TERMO1> inválido",
        "esperado set, :=",//"<COMANDO1> inválido",
        "esperado :=",//"<ATRIBUICAO1> inválido",
        "esperado set, ",//"<MANIPULACAO_TIPOS_COMPOSTOS1> inválido",
        "esperado ifFalse, ifTrue",//"<SELECAO1> inválido",
        "esperado ifFalse, ifTrue, ",//"<SELECAO0> inválido",
        "esperado whileFalse, whileTrue",//"<REPETICAO1> inválido",
        "esperado ifFalse, ifTrue, whileFalse, whileTrue",//"<COMANDO2> inválido",
        "esperado identificador, ), ",//"<LISTA_DE_CAMPOS1> inválido",
        "esperado :, ), =, ou , ",//"<LISTA_DE_IDENTIFICADORES1> inválido",
        "esperado identificador, execute, ",//"<DEC_VAR1> inválido",
        "esperado ), ou ,  ",//"<LISTA_DE_EXPRESSOES1> inválido",
        "esperado end, ifFalse",//"<SELECAO2> inválido",
        "esperado expressao",//"<RELACIONAL1> inválido",
        "esperado expressao",//"<FATOR1> inválido"
    };
}
