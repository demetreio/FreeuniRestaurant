-- menuebis datarigeba, pirveli parametri anu primary key aris tarigi, meore ki kerdzi
-- anu ra tarigze ra kerdzebi gvqonda imit gaivseba es relacia. siamrtivistvis jerjerobit DATE type-is
-- magivrad VARCHAR-s vigeb, mere sheidzleba sheicvalos, tumca es aravitar problemebs ar sheqmnis.

create table menuDates(menuID VARCHAR(10) NOT NULL, foodID INT NOT NULL, PRIMARY KEY(menuID));