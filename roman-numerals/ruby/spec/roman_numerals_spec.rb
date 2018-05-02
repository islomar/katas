def convert(in_arabic)
    ""
end

describe "Converting arabic numbers to roman numerals" do
    context "Romans didn't have a 0" do
        it "converts 0 to a blank string" do
            expect(convert(0)).to eq("")
        end

        it "converts 1 to I" do
            expect(convert(1)).to eq("I")
        end
    end
end