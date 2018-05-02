def convert(in_arabic)
    return "" if in_arabic.zero?
    return "I" if in_arabic == 1
    return "V" if in_arabic == 5
    "I" + convert(in_arabic - 1)
end

describe "Converting arabic numbers to roman numerals" do
    context "Romans didn't have a 0" do
        it "converts 0 to a blank string" do
            expect(convert(0)).to eq("")
        end

        {
            1 => "I",
            5 => "V",
            2 => "II"
        }.each_pair do |arabic, roman|
            it "converts #{arabic} to #{roman}" do
                expect(convert(arabic)).to eq(roman)
            end
        end
    end
end