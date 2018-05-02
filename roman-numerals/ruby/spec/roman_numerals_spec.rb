CONVERSIONS = [
    [1000, "M"],
    [900, "CM"],
    [500, "D"],
    [400, "CD"],
    [100, "C"],
    [90, "XC"],
    [50, "L"],
    [40, "XL"],
    [10, "X"],
    [9, "IX"],
    [5, "V"],
    [4, "IV"],
    [1, "I"]
]

def conversion_factors_for(in_arabic)
    CONVERSIONS.find { |arabic, _| arabic <= in_arabic }
end

def convert(in_arabic)
    return "" if in_arabic.zero?
    arabic, roman = conversion_factors_for(in_arabic)
    roman + convert(in_arabic - arabic)
end

describe "Converting arabic numbers to roman numerals" do
    context "Romans didn't have a 0" do
        it "converts 0 to a blank string" do
            expect(convert(0)).to eq("")
        end

        {
            1 => "I",
            2 => "II",
            4 => "IV",
            5 => "V",
            6 => "VI",
            9 => "IX",
            10 => "X",
            40 => "XL",
            50 => "L",
            90 => "XC",
            100 => "C",
            400 => "CD",
            500 => "D",
            900 => "CM",
            1000 => "M"
        }.each_pair do |arabic, roman|
            it "converts #{arabic} to #{roman}" do
                expect(convert(arabic)).to eq(roman)
            end
        end
    end
end