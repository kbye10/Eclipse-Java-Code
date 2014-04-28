#!/usr/bin/perl

my $numEmpl = 200;
open(EMPL, ">employees");
die "cannot open file employees\n" unless EMPL;
my ($str, $str1, $str2, $str3);
my $i;
for ($i=1 ; $i <= $numEmpl ; $i++) {
    print "\r$i";
# First
    $str = &makeName(3,5);
    print EMPL "$str\n";
# Last
    $str = &makeName(5,8);
    print EMPL "$str\n";
# SSN
    $str1 = &makeDigits(3,3);
    $str2 = &makeDigits(2,2);
    $str3 = &makeDigits(4,4);
    print EMPL "$str1-$str2-$str3\n";
# Age
    do {
	$str = &makeDigits(2,2);
    } until $str >= 18 and $str < 70;
    print EMPL "$str\n";
# Salary
    do {
	$str1 = &makeDigits(4,5);
    } until $str1 >= 1000;
    $str2 = &makeDigits(2,2);
    print EMPL "$str1.$str2\n";
}
print "\n";
close(EMPL);

sub makeName() {
    my $str = "";
    my ($min, $max) = @_;
    my $maxLen = $max-$min+1;
    my $len = $min + int (rand $maxLen);
    # print "min=$min max=$max len=$len\n";
    my $base = ord 'A';
    my $i;
    for ($i=0 ; $i < $len ; $i++) {
	my $ch = chr ($base + int (rand 26));
	$str .= $ch;
	$base = ord 'a';
    }
    return $str;
}

sub makeDigits() {
    my $str = "";
    my ($min, $max) = @_;
    my $maxLen = $max-$min+1;
    my $len = $min + int (rand $maxLen);
    my $base = ord '0';
    my $i;
    for ($i=0 ; $i < $len ; $i++) {
	my $ch = chr ($base + int (rand 10));
	$str .= $ch;
    }
    return $str;
}
