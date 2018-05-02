def convert(in_arabic)
    return "" if in_arabic.zero?
    "I"
end

describe "Converting arabic numbers to roman numerals" do
    context "Romans didn't have a 0" do
        it "converts 0 to a blank string" do
            expect(convert(0)).to eq("")
        end

        it "converts 1 to I" do
            expect(convert(1)).to eq("I")
        end

        it "converts 5 to V" do
            expect(convert(5)).to eq("V")
        end
    end
end